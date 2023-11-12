package com.example.tatyamyam.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.repository.HealthRepository;

@Service
public class HealthService {
	private final HealthRepository healthRepository;
	
	public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }
	
	public Health getOrCreateTodayHealth(Long userID) {
        // 今日の日付を取得
        LocalDate today = LocalDate.now();

        // ユーザーIDと日付でhealthを検索
        Health health = healthRepository.findByUserIdAndDate(userID, today);

        // healthが存在しない場合は新規作成
        if (health == null) {
            health = new Health();
            health.setUserId(userID);
            health.setDate(today);
            // 他の必要な初期化処理も行うかもしれません

            // データベースに保存
            health = healthRepository.save(health);
        }

        return health;
    }

}
