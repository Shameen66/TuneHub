package com.example.tunehub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String gender;
	String role;
	boolean ispremium=false;
	
	public User() {
		super();
	}

	public User(int id, String username, String email, String password, String gender, String role, boolean ispremium) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.role = role;
		this.ispremium = ispremium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isIspremium() {
		return ispremium;
	}

	public void setIspremium(boolean ispremium) {
		this.ispremium = ispremium;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", role=" + role + ", ispremium=" + ispremium + "]";
	}

}