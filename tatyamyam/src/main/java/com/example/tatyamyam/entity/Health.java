package com.example.tatyamyam.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

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
	
	@Column(name = "created_at", insertable = true, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    
    @Column(name = "comment")
	private String comment;
    
    //★要確認★healthテーブルのstatus:enum　に対してのコード//
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private HealthStatus status;
    
    
    public Health() {
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }
    
    //HealthのEntityにweightを紐づけする
    @OneToOne(mappedBy = "health", fetch = FetchType.LAZY)
    private Weight weight;

 @OneToOne(mappedBy = "health", fetch = FetchType.LAZY)
  private Blood_Pressure blood_pressure;
 
}
