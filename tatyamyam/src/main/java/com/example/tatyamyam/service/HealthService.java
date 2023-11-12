package com.example.tatyamyam.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.repository.HealthRepository;

@Service
public class HealthService {
	private final HealthRepository healthRepository;
	
	public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }
	
	public Health getOrCreateTodayHealth(Account account) {
        // 今日の日付を取得
		Timestamp today = new Timestamp(System.currentTimeMillis());
        System.out.println(today);
        // ユーザーIDと日付でhealthを検索
        Long userId = account.getId();
        Health health = healthRepository.findByUserIdAndCreatedAt(userId, today);

        // healthが存在しない場合は新規作成
        if (health == null) {
            health = new Health();
            System.out.println(account + "healthService");
            health.setAccount(account);
            // 他の必要な初期化処理も行うかもしれません

            // データベースに保存
            health = healthRepository.save(health);
        }

        return health;
    }

}
