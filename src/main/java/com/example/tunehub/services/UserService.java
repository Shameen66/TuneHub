package com.example.tunehub.services;

import com.example.tunehub.entity.User;

public interface UserService {
	public String addUser(User user);
	public boolean emailExits(String email);
	public String getPassword(String email);
	public String getrole(String email);
	public User getuser(String email);
	public void updateUser(User user); 
}