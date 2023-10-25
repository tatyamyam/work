package com.example.tatyamyam.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.form.SignupForm;
import com.example.tatyamyam.repository.AccountRepository;



@Service
public class AccountService {
	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;
	
	public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Transactional
	public Account create(SignupForm signupForm) {
		Account account = new Account();
		
		account.setEmail(signupForm.getEmail());
		account.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		
		return accountRepository.save(account);
		
	}
	
	
	//メールアドレスが登録済みかどうかを判定する
	public boolean isEmailRegistered(String email) {
		Account account = accountRepository.findByEmail(email);
		return account != null;
	}
	
	//パスワードとパスワード(確認用)の入力値が一致しているか判定する
	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
	
}
