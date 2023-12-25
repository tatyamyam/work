package com.example.tatyamyam.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.form.BloodPressureForm;
import com.example.tatyamyam.security.UserDetailsImpl;
import com.example.tatyamyam.service.Blood_PressureService;
import com.example.tatyamyam.service.HealthService;

@Controller
public class BloodPressureController {
	private final Blood_PressureService blood_PresssureService;
	private final HealthService healthService;
	
	public BloodPressureController(Blood_PressureService blood_PresssureService, HealthService healthService) {
		this.healthService = healthService;
		this.blood_PresssureService = blood_PresssureService;
	}
	
	@GetMapping("/regist_bloodpressure")
	public String showRegistrationForm(Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		// userDetailsImplからuserIDを取得
        Long userID = userDetailsImpl.getUserId();
        // blood_PresssureServiceのインスタンスを使ってhaveHealthメソッドを呼び出す
        blood_PresssureService.haveHealth(userID);
        return "regist_bloodpressure";
        
        
	}
	
	@PostMapping("/regist_bloodpressure")
    public String submit_BloodPressure(BloodPressureForm bloodPressureForm, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) { 
	 Account account = userDetailsImpl.getAccount();
	// 今日のhealthカラムが存在するか確認し、なければ作成
	 Health health = healthService.getOrCreateTodayHealth(account);

	 //Blood_Pressure.Serive内で体重をDBへ保存する
	 blood_PresssureService.saveBlood_Pressure(bloodPressureForm, health);

        return "regist_bloodpressure";
    }
	

}
