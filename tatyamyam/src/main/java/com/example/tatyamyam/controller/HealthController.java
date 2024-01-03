package com.example.tatyamyam.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.security.UserDetailsImpl;
import com.example.tatyamyam.service.HealthService;

@Controller
public class HealthController {
	private final HealthService healthService;
	
	public HealthController(HealthService healthService) {
		this.healthService = healthService;
	}
	
	@GetMapping("/list")
    public String list(Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
        Account account = userDetailsImpl.getAccount();
        Health[] healths = healthService.getHealth(account);
        System.out.println(healths);
        model.addAttribute("healths", healths);
        System.out.println(healths[2].getWeight());
        System.out.println(healths[2].getId());
        System.out.println(healths[3].getId());
        System.out.println(healths[4].getId());
        System.out.println(healths[5].getId());
        System.out.println(healths[6].getId());
        
        return "list";
    }
	
	
	

}
