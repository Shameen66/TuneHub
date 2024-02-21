package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.Repository.UserRepository;
import com.example.tunehub.entity.User;

@Service
public class UserServiceImplentation implements UserService{
	@Autowired
	UserRepository Urepo;
	
	@Override
	public String addUser(User user) {
		Urepo.save(user);
		return null;
	}

	@Override
	public boolean emailExits(String email) {
		if(Urepo.findByEmail(email)==null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String getPassword(String email) {
		User user=Urepo.getByEmail(email);
		String password=user.getPassword();
		return password;
	}

	@Override
	public String getrole(String email) {
		User user=Urepo.getByEmail(email);
		String role=user.getRole();
		return role;
	}

	@Override
	public User getuser(String email) {
		
		return Urepo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
	 Urepo.save(user);
		
	}

	

}