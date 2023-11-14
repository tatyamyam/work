package com.example.tatyamyam.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.entity.Health;

public interface HealthRepository extends JpaRepository<Health, Long> {

	Health findByAccountAndCreatedAt(Account account, Timestamp createdAt);

}
