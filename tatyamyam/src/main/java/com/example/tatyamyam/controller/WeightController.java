package com.example.tatyamyam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.tatyamyam.form.WeightForm;
import org.springframework.ui.Model;


@Controller
public class WeightController {
	
	@GetMapping("/regist_weight")
	//showRegistrationForm メソッドを追加し、GETリクエストで登録フォームを表示するためのメソッドとする。
	//Modelオブジェクトを使用して WeightForm を登録フォームに渡す。
	public String showRegistrationForm(Model model) {
        model.addAttribute("weightForm", new WeightForm());
        return "regist_weight";
    }
	
	 @PostMapping("/regist_weight")
	    public String submit_Weight(WeightForm weightForm) {
	        System.out.println(weightForm.getWeight());
	        // ここにデータベースへの保存ロジックを追加
	        // 一覧情報の取得、画面への情報設定、一覧画面への遷移の処理も追加すること

	        return "regist_weight";
	    }

}
