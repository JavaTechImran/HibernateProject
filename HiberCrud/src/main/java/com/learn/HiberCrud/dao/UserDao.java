package com.learn.HiberCrud.dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learn.HiberCrud.entities.User;
import com.learn.HiberCrud.helper.FactoryProvider;


public class UserDao {
	
	//registering new users
	public static int save(User user) {
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=null;
		Integer count=0;
		try {
			tx=s.beginTransaction();
			count=(Integer)s.save(user);
			tx.commit();
			
		}catch(HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			// TODO: handle exception
		}
		return count;
	}
	
	//login user by email and password
	
	public static boolean authenticate(String email, String password) {
		Session session=FactoryProvider.getFactory().openSession();
		Transaction tc=null;
		User user=null;
		try {
			tc=session.beginTransaction();
			String query="from User where email=: e and password=: p";
			Query q=session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			user=(User)q.uniqueResult();
			if(user!=null && user.getPassword().equals(password)) {
				return true;
			}
			
			tc.commit();
		} catch (Exception e) {
			if(tc!=null) {
				tc.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	
	//update users
	public static void updateUser(User user) {
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			s.update(user);
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//delete users
	public static void deleteUser(int id) {
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=null;
		try {
			tx=s.beginTransaction();
			User user=s.get(User.class, id);
			if(user!=null) {
				s.delete(user);
				System.out.println("User is deleted!!");
			}
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	//getting list of users
	public static List<User> getHomeUsers(){
		Session ses=FactoryProvider.getFactory().openSession();
		Transaction tra=null;
		List<User> listUser=null;
		
		try {
			tra=ses.beginTransaction();
			listUser=ses.createQuery("from User").getResultList();
			tra.commit();
			ses.close();
			
		} catch (Exception e) {
			if(tra!=null) {
				tra.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return listUser;
	}

	public static User getUser(int id) {
		Session s=FactoryProvider.getFactory().openSession();
		Transaction tx=null;
		User  user=null;
		try {
			tx=s.beginTransaction();
			user=s.get(User.class, id);
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		}
		return user;
	}
}
	
	
