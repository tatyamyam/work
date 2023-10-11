package com.example.tatyamyam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tatyamyam.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
