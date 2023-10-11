package com.example.tatyamyam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.tatyamyam.form.WeightForm;
//import org.springframework.ui.Model;


@Controller
public class WeightController {
	
	@GetMapping("/regist_weight")
    public String regist_Weight() {
        return "regist_weight";
    }
	
	@PostMapping("/regist_weight")
	public String submit_Weight(WeightForm weightForm) {
		System.out.println(weightForm.getWeight());
		return "regist_weight";
		
		//DB保存
		//一覧の情報取得
		//画面へ送る情報を設定
		//一覧画面への遷移

	}

}
