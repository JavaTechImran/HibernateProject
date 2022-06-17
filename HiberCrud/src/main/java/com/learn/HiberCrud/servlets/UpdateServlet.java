package com.learn.HiberCrud.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.HiberCrud.dao.UserDao;
import com.learn.HiberCrud.entities.User;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try {
			int uid=Integer.parseInt(request.getParameter("id").trim());
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String dob=request.getParameter("dob");
			String address=request.getParameter("city");
			
			User user=new User(uid, name, email, password, phone, dob, address);
			UserDao.updateUser(user);
			
			response.sendRedirect("home.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
