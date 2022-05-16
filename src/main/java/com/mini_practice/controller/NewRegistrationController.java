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


@WebServlet("/newreg")
public class NewRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NewRegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("new_registration.jsp");;
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
				DAOservice service = new DAOserviceImp();
				service.connectDB();
				service.createRegistration(name, city, email, mobile);
				request.setAttribute("error", "registration save");
				
				RequestDispatcher rd = request.getRequestDispatcher("new_registration.jsp");;
				rd.include(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");;
				rd.include(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "session timeout");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");;
			rd.include(request, response);
			e.printStackTrace();
		}
	
	}

}
