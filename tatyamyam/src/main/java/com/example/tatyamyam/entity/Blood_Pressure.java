package com.example.tatyamyam.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="blood_pressure")
@Data
public class Blood_Pressure {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "health_id")
	private Health health;
	
	@Column(name = "s_bp")
	private int s_Bp;
	
	@Column(name = "d_bp")
	private int d_Bp;
	
	@Column(name = "puls")
	private int puls;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public void setS_Bp(int s_Bp) {
        this.s_Bp = s_Bp;
    }
    
    public void setD_Bp(int d_Bp) {
        this.d_Bp = d_Bp;
    }
    
    public void setPuls(int puls) {
        this.puls = puls;
    }
    
}
