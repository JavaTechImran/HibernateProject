package com.learn.hibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.hibernate.dao.UserDao;
import com.learn.hibernate.entities.User;
import com.learn.hibernate.helper.FactoryProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDao userd=new UserDao(FactoryProvider.getFactory());
		User user=userd.getUserByEmailAndPassword(email, password);
		//System.out.println(user);
		if(user==null) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("home.jsp");
		}
	}

}
