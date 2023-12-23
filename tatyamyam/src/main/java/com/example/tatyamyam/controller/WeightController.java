package com.example.tatyamyam.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.form.WeightForm;
import com.example.tatyamyam.security.UserDetailsImpl;
import com.example.tatyamyam.service.HealthService;
import com.example.tatyamyam.service.WeightService;


@Controller
public class WeightController {
	private final WeightService weightService;
	private final HealthService healthService;
	
	public WeightController(WeightService weightService, HealthService healthService) {
        this.weightService = weightService;
        this.healthService = healthService;
    }
	
	@GetMapping("/regist_weight")
	//showRegistrationForm メソッドを追加し、GETリクエストで登録フォームを表示するためのメソッドとする。
	//Modelオブジェクトを使用して WeightForm を登録フォームに渡す。
	public String showRegistrationForm(Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		// userDetailsImplからuserIDを取得
        Long userID = userDetailsImpl.getUserId();
		// WeightServiceのインスタンスを使ってhaveHealthメソッドを呼び出す
        weightService.haveHealth(userID);
        return "regist_weight";
    }
	
	 @PostMapping("/regist_weight")
	    public String submit_Weight(WeightForm weightForm, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) { 
		 Account account = userDetailsImpl.getAccount();
		// 今日のhealthカラムが存在するか確認し、なければ作成
		 Health health = healthService.getOrCreateTodayHealth(account);

		 //Weight.Serive内で体重をDBへ保存する
		 	weightService.saveWeight(weightForm, health);

	        return "regist_weight";
	    }

}
