package com.example.tatyamyam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.tatyamyam.entity.Weight;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.form.WeightForm;
import com.example.tatyamyam.repository.WeightRepository;

@Service
public class WeightService {
	private final WeightRepository weightRepository;
	
	public WeightService(WeightRepository weightRepository) {
		this.weightRepository = weightRepository;
	}
	
	public void saveWeight(WeightForm weightForm, Health health) {
		// Weightテーブルに値を保存
        Weight weight = new Weight();
		// 体重の値をセット
        weight.setWeight(weightForm.getWeight());
		// Helthの値をセット
		weight.setHealth(health);
        weightRepository.save(weight);
	}

	public Health haveHealth() {
		// ここは一旦nullで作っているのでfindで取得したら入らない (後で消す)
		Health health = null;
		// 1:ログインしているユーザーを取得
		
		// 2:今日の日付を取得
		// 3: 今日の日付のログインしているユーザーのHelthテーブルがあるかを確認
			// ない場合 (Helthテーブルを作成してあげる)
			
		return health;
	}
	
	// コントローラクラスのweightSubmitメソッド内
	@PostMapping("/regist_weight")
	public String weightSubmit(WeightForm weightForm) {
	    System.out.println(weightForm.getWeight());
		// healthを持っているか確認
		Health health = haveHealth();

		saveWeight(weightForm , health);

	    return "end";
	}

}