/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.studycase1.controller;

import com.mitrais.studycase1.dao.UserDao;
import com.mitrais.studycase1.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andre_P772
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {
    private static final String HOME = "./index.jsp";
    private static final String LOGIN = "./login.jsp";
    private static final String REGIS = "./register.jsp";
    private final UserDao dao;
    
    public RegisterController() {
        super();
        dao = new UserDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        String forward = "";
        if (action.equalsIgnoreCase("regis")){
            forward = REGIS;  
        } 
        else {
            forward = LOGIN;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String uname = request.getParameter("userName");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        String forward = "";
               
        if (!uname.isEmpty() && !pass.isEmpty() && !email.isEmpty())
        {
            try {
                User user = new User();
                Date date = new Date();
                user.setuname(uname);
                user.setpassword(pass);
                user.setregisterdate(date);
                user.setemail(email);
                
                dao.addUser(user);
                forward = LOGIN;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.include(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Registration Contoller";
    }

}
