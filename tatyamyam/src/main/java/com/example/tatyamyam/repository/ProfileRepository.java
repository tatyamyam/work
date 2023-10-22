package com.example.tatyamyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tatyamyam.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
