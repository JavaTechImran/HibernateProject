package com.learn.HiberCrud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 500,nullable = false,unique = true)
	private String name;
	@Column(length = 500,nullable = false,unique =true )
	private String email;
	@Column(length = 500,nullable = false)
	private String password;
	@Column(length = 10,nullable = false,unique = true)
	private String phone;
	@Column(length = 500,nullable = false)
	private String dob;
	@Column(length = 500,nullable = false)
	private String address;
	public User(int id, String name, String email, String password, String phone, String dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
	}
	public User(String name, String email, String password, String phone, String dob, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
	}
	public User(int id, String name, String phone, String dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
