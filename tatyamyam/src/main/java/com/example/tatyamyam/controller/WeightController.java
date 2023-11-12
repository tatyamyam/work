package com.example.tatyamyam.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.entity.Weight;
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
		 Long userID = userDetailsImpl.getUserId();
		 
		// 今日のhealthカラムが存在するか確認し、なければ作成
		 Health health = healthService.getOrCreateTodayHealth(userID);
		 
		// weightを追加し、作成したhealthのidをhealth_idにセット
	        //weightForm.setHealth(health);
	        //weightService.addWeight(weightForm);
	        
	     // WeightFormからWeightに変換
	        Weight weight = weightForm.toWeight();

	        // 作成したhealthの参照を設定
	        weight.setHealth(health);

	        // Weightを追加
	        weightService.addWeight(weight);
	        
		 
		 
	        //System.out.println(weightForm.getWeight());
	        // ここにデータベースへの保存ロジックを追加
	        
	        
	        
	         
	        // 一覧情報の取得、画面への情報設定、一覧画面への遷移の処理も追加すること

	        return "regist_weight";
	    }

}
