package com.example.tatyamyam.service;

import org.springframework.stereotype.Service;

import com.example.tatyamyam.entity.Blood_Pressure;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.form.BloodPressureForm;
import com.example.tatyamyam.repository.AccountRepository;
import com.example.tatyamyam.repository.Blood_PressureRepository;


@Service
public class Blood_PressureService {
	private final Blood_PressureRepository blood_PressureRepository;
	
	public Blood_PressureService(Blood_PressureRepository blood_PressureRepository, AccountRepository accountRepository) {
		this.blood_PressureRepository = blood_PressureRepository;
	}
	
	public void addBlood_Pressure(Blood_Pressure blood_pressure) {
        
		blood_PressureRepository.save(blood_pressure);
    }
	
	public void saveBlood_Pressure(BloodPressureForm bloodPressureForm, Health health) {
		// Weightテーブルに値を保存
		Blood_Pressure bloodPressure = new Blood_Pressure();
		// 最高血圧の値をセット
		bloodPressure.setS_Bp(bloodPressureForm.getS_Bp());
		System.out.println("出力確認①");
		// 最低血圧の値をセット
		bloodPressure.setD_Bp(bloodPressureForm.getD_Bp());
		System.out.println("出力確認②");
		//脈拍の値をセット
		bloodPressure.setPuls(bloodPressureForm.getPuls());
		System.out.println("出力確認③");

		// Helthの値をセット
        bloodPressure.setHealth(health);
        blood_PressureRepository.save(bloodPressure);
	}

	public Health haveHealth(Long userID) {
		Health health = null;
		return health;

	}
}
