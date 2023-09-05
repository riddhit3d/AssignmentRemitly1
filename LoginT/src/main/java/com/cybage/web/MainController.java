package com.cybage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;

import com.cybage.entity.User;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
//	@GetMapping("/")
//	public String home() {
//		return "index";
//	}

	@GetMapping("/register12")
	public String submitForm(@ModelAttribute("user") User user) {
	    System.out.println(user);
	    return "register_success";
	}
	
}
