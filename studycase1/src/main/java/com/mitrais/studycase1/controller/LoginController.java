/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.studycase1.controller;

import com.mitrais.studycase1.dao.HpDao;
import com.mitrais.studycase1.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
    private static final String HOME = "./index.jsp";
    private static final String LOGIN = "./login.jsp";
    private final UserDao dao;
    
    public LoginController() {
        super();
        dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {       
        String action = request.getParameter("action");
        String forward = "";
        if (action.equalsIgnoreCase("login")){
            forward = LOGIN;  
        } 
        else if (action.equalsIgnoreCase("logout")){
            forward = LOGIN;  
            PrintWriter out = response.getWriter();
            out.println("thank you!!, Your session was destroyed successfully!!");
            HttpSession session = request.getSession(false);
            session.removeAttribute("userName");
            session.getMaxInactiveInterval();
        } 
        else {
            forward = HOME;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String uname = request.getParameter("userName");
        String pass = request.getParameter("password");
        String forward = "";
        if (!uname.isEmpty() && !pass.isEmpty())
        {
            boolean check = dao.checkUser(uname, pass);
            if (check)
            {
                forward = HOME;
                session.setAttribute("userName", uname);
                response.sendRedirect(forward);
            }
            else
            {
                forward = LOGIN;
                session.setAttribute("errMessage", "Username / Password wrong !");
                
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.include(request, response);
            }
        }
        else
        {
            forward = LOGIN;
            String errmsg = "";
            if (uname.isEmpty())
            {
               errmsg = "Username cannot null";
            }
            if (pass.isEmpty())
            {
                errmsg += errmsg.isEmpty() ? "Password cannot null" : " & Password cannot null";
            }
            
            session.setAttribute("errMessage", errmsg);
            
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.include(request, response);
        }
        
        
    }
    
    @Override
    public String getServletInfo() {
        return "Login Contoller";
    }
    
}
