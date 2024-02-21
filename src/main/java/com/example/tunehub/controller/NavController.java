package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	@GetMapping("/")
	public String Homepage() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String Signup() {
		return "signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	@GetMapping("/addsongs")
	public String addsongs() {
		return "addsongs";
	}
	
	@GetMapping("/makepayment")
	public String makepayment() {
		return "makepayment";
	}
	
	@GetMapping("/playlistsuccess")
	public String playlistsuccess() {
		return "playlistsuccess";
	}
	
	
	
}