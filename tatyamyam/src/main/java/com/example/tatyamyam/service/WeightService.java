package com.example.tatyamyam.service;

import org.springframework.stereotype.Service;

import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.entity.Weight;
import com.example.tatyamyam.form.WeightForm;
import com.example.tatyamyam.repository.AccountRepository;
import com.example.tatyamyam.repository.WeightRepository;


@Service
public class WeightService {
	private final WeightRepository weightRepository;
	
	
	public WeightService(WeightRepository weightRepository, AccountRepository accountRepository) {
		this.weightRepository = weightRepository;
	}
	
	public void addWeight(Weight weight) {
        
        weightRepository.save(weight);
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

	public Health haveHealth(Long userID) {
		// ここは一旦nullで作っているのでfindで取得したら入らない (後で消す)
		Health health = null;
		// 1:ログインしているユーザーを取得⇒WeightContorllerで定義する
		
		// 2:今日の日付を取得
		
		// 3: 今日の日付のログインしているユーザーのHelthテーブルがあるかを確認
		// ない場合 (Helthテーブルを作成してあげる)
			
		return health;
	}

}