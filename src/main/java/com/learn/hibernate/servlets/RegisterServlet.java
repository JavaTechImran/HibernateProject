package com.learn.hibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.learn.hibernate.entities.User;
import com.learn.hibernate.helper.FactoryProvider;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String dob=request.getParameter("DOB");
			String address=request.getParameter("city");
			
			User user=new User(name, email, password, phone, dob, address);
			Session hibernateSession=FactoryProvider.getFactory().openSession();
			Transaction tx=hibernateSession.beginTransaction();
			int userId=(Integer) hibernateSession.save(user);
			tx.commit();
			hibernateSession.close();
			
			//response.setContentType("text/html");
			//PrintWriter out=response.getWriter();
            //out.println("Successfully saved");
			//out.println("<br>User id is" +userId);
			response.sendRedirect("login.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
