package com.example.tatyamyam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoggedOutController {
	@GetMapping("/loggedOut")
	public String logOutPage() {
		return "loggedOut";
	}

}
