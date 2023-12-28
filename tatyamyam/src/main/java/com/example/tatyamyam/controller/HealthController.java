package com.example.tatyamyam.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.security.UserDetailsImpl;
import com.example.tatyamyam.service.HealthService;

@Controller
@RequestMapping("/list")
public class HealthController {
	private HealthService healthService;
	
	@GetMapping("/list")
    public String list(Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        Account account = userDetailsImpl.getAccount();
        Health[] healths = healthService.getHealth(account);
        model.addAttribute("healths", healths);
        
        return "list";
    }
	
	
	

}
