package com.example.tatyamyam.entity;

import java.sql.Timestamp;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Table(name="profile")
@Data
public class Profile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Profile profile;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "goal_comment")
	private String goal_Comment;
	
	@Column(name = "height")
	private double height;
	
	@Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;
	
	
	
	
	
	

}
