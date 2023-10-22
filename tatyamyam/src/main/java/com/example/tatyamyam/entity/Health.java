package com.example.tatyamyam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name="health")
@Data
public class Health {
	public enum HealthStatus {
	    HEALTHY, UNHEALTHY, UNKNOWN; // 例として
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Account account;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    
    @Column(name = "comment")
	private String comment;
    
    //★要確認★healthテーブルのstatus:enum　に対してのコード//
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private HealthStatus status;
    
    
    
    
	

}
