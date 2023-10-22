package com.example.tatyamyam.entity;

import java.sql.Timestamp;

import lombok.Data;
import jakarta.persistence.*;


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
	private Blood_Pressure blood_Pressure;
	
	@Column(name = "s_bp")
	private int s_Bp;
	
	@Column(name = "d_bp")
	private int d_Bp;
	
	@Column(name = "plus")
	private int plus;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

}
