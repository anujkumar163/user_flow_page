package com.mini_practice.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini_practice.model.DAOservice;
import com.mini_practice.model.DAOserviceImp;


@WebServlet("/listall")
public class ListAllRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListAllRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			DAOservice service = new DAOserviceImp();
			service.connectDB();
			ResultSet result = service.getAllReg();
			
			request.setAttribute("result", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("list_registration.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
