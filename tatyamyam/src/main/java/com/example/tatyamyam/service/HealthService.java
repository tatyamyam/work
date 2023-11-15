package com.example.tatyamyam.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        Timestamp today = Timestamp.valueOf(LocalDateTime.now());

        // ユーザーIDと日付でhealthを検索
        Health health = healthRepository.findByAccountAndCreatedAt(account, today);

        // healthが存在しない場合は新規作成
        if (health == null) {
            health = new Health();
            health.setAccount(account);
            health.setCreatedAt(Timestamp.valueOf(LocalDateTime.now())); // ここでcreated_atに値をセット
            // 他の必要な初期化処理も行うかもしれません

            // データベースに保存
            health = healthRepository.save(health);
        }

        return health;
    }
}