package com.example.tunehub.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tunehub.entity.User;
import com.example.tunehub.services.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	@Autowired
	UserService Uservice;
	@PostMapping("/createorder")
	@ResponseBody
	public String createorder() {
		Order order=null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_xSxGbBWMNWAyta", "WKHcEhmLKK7bYz6s7TXTsBWX");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",50000);
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1","Tea, Earl Grey, Hot");
			orderRequest.put("notes",notes);

			 order = razorpay.orders.create(orderRequest);
		}catch (Exception e) {
			System.out.println("exception created while creating order.");
		}
		return order.toString();
	}
	
	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam  String orderId, @RequestParam String paymentId, @RequestParam String signature) {
	    try {
	        // Initialize Razorpay client with your API key and secret
	        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_xSxGbBWMNWAyta", "WKHcEhmLKK7bYz6s7TXTsBWX");
	        // Create a signature verification data string
	        String verificationData = orderId + "|" + paymentId;

	        // Use Razorpay's utility function to verify the signature
	        boolean isValidSignature = Utils.verifySignature(verificationData, signature, "WKHcEhmLKK7bYz6s7TXTsBWX");

	        return isValidSignature;
	    } catch (RazorpayException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@GetMapping("/payment-success")
	public String paymentsuccess(HttpSession session){
		String email=(String) session.getAttribute("email");
		User user=Uservice.getuser(email);
		user.setIspremium(true);
		Uservice.updateUser(user);
		return "login";
	}
	
	@GetMapping("/payment-failure")
	public String paymentfailure( ){
		return "login";
	}
}
