package com.example.tatyamyam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Data;


@Entity
@Table(name="weight")
@Data
public class Weight {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@JoinColumn(name = "health_id")
	private Health health;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

}




//CREATE TABLE IF NOT EXISTS weight (
//	     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//	     health_id INT NOT NULL,
//	     FOREIGN KEY(health_id) REFERENCES health(id),
//	     weight INT NOT NULL,
//	     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
//	     updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP     
//	);