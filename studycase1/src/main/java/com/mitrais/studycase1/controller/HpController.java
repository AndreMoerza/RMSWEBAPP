/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.studycase1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.mitrais.studycase1.dao.HpDao;
import com.mitrais.studycase1.model.Handphone;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Andre_P772
 */
public class HpController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/handphone.jsp";
    private static String LIST_HP = "/listhandphone.jsp";
    private static String LOGIN = "./login.jsp";
    private HpDao dao;
    
    public HpController() {
        super();
        dao = new HpDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (action.equalsIgnoreCase("delete")){
                String hp_id = request.getParameter("hp_id");
                dao.deleteHp(hp_id);
                forward = LIST_HP;
                request.setAttribute("hps", dao.getAllHps());    
            } else if (action.equalsIgnoreCase("edit")){
                forward = INSERT_OR_EDIT;
                String hp_id = request.getParameter("hp_id");
                Handphone hp = dao.getHpById(hp_id);
                request.setAttribute("handphone", hp);
            } else if (action.equalsIgnoreCase("listhandphone")){
                forward = LIST_HP;
                request.setAttribute("hps", dao.getAllHps());
            } else {
                forward = INSERT_OR_EDIT;
            }
        } else {
            forward = LOGIN;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Handphone hp = new Handphone();
        hp.sethp_id(request.getParameter("hp_id"));
        hp.sethp_name(request.getParameter("hp_name"));
        try {
            Date reg = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("prod_date"));
            hp.sethp_prod_date(reg);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        hp.sethp_type(request.getParameter("hp_type"));
        String hp_id = request.getParameter("hp_id");
        if(hp_id == null || hp_id.isEmpty())
        {
            dao.addHp(hp);
        }
        else
        {
            hp.sethp_id(hp_id);
            dao.checkHp(hp);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_HP);
        request.setAttribute("hps", dao.getAllHps());
        view.forward(request, response);
    }
}
