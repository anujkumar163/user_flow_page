package com.mini_practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini_practice.model.DAOservice;
import com.mini_practice.model.DAOserviceImp;


@WebServlet("/verifyLogin")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginControllerServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DAOservice service = new DAOserviceImp();
		service.connectDB();
		//request.setAttribute("error", "invalid entries");
		boolean status = service.verifycredential(email, password);
		if(status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(10);
			
			//System.out.println("welcome");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}else {
			//System.out.println("invalid username and input");
			request.setAttribute("error", "invalied details");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
		
		
		
		
		
		
		
	}

}
