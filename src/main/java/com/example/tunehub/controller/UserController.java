package com.example.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.tunehub.entity.User;
import com.example.tunehub.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService Uservice;
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute User user ) {
		boolean emailfound=Uservice.emailExits(user.getEmail());
		if(emailfound==false) {
			Uservice.addUser(user);
			System.out.println(user);
		}else {
			System.out.println("email alredady exists.");
		}
	
				return "index";
	}

	@PostMapping("/validate")
	public String validate(@ModelAttribute User user,HttpSession session) {
		boolean emailfound=Uservice.emailExits(user.getEmail());
		String password=user.getPassword();
		if(emailfound==false) {
			return "/login";
		}else {
		String role=Uservice.getrole(user.getEmail());
		System.out.println(emailfound);
		if(password.equals(Uservice.getPassword(user.getEmail()))) {
			session.setAttribute("email", user.getEmail());
			if(role.equals("Admin")) {
				user.setIspremium(true);
				return "admin";
			}else {
				return "User";
			}
		}else {
			return "login";
		}
		}
		
	}
//	@GetMapping("/exploresongs")
//	public String exploresongs(String email) {
//		User user=Uservice.getuser(email);
//		boolean primestatus=user.isIspremium();
//		if(primestatus ==true) {
//			return "User";
//		}else {
//			return "makepayment";
//		}
//	}
}