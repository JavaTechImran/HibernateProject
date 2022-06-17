package com.learn.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.learn.hibernate.entities.User;

public class UserDao {
	
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	//get user by email and password
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user=null;
		try {
			String query="from User where email=: e and password=:  p";
			Session session=this.factory.openSession();
			Query q=session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			user=(User)q.uniqueResult();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return user;
	}
	

}
