package com.example.tatyamyam.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tatyamyam.entity.Health;

public interface HealthRepository extends JpaRepository<Health, Long> {

	Health findByUserIdAndCreatedAt(Long userID, Timestamp today);

}
