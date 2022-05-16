package com.mini_practice.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mini_practice.model.DAOservice;
import com.mini_practice.model.DAOserviceImp;


@WebServlet("/Update")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		RequestDispatcher rd = request.getRequestDispatcher("update_registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		DAOservice service = new DAOserviceImp();
		service.connectDB();
		service.updateReg(email, mobile);
		ResultSet result = service.getAllReg();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("list_registration.jsp");
		rd.forward(request, response);
	}

}
