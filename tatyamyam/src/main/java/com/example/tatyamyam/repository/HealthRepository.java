package com.example.tatyamyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tatyamyam.entity.Health;

public interface HealthRepository extends JpaRepository<Health, Integer> {

}
