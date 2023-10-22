package com.example.tatyamyam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.Data;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="account")
@Data
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp createdAt;
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp updatedAt;
	

    
    //UserDetailsImpl.javaでユーザが有効であればtrue	を返す処理をいれるためこちらで宣言が必要
	public boolean getEnabled() {
		return false;
	}
	

}
