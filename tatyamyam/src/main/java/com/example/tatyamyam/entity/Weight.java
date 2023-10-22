package com.example.tatyamyam.entity;

import java.sql.Timestamp;

import lombok.Data;
import jakarta.persistence.*;


@Entity
@Table(name="weight")
@Data
public class Weight {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "health_id")
	private Health health;
	
	@Column(name = "weight")
	private int weight;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

}