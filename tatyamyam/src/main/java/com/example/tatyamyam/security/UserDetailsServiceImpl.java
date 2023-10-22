package com.example.tatyamyam.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.tatyamyam.entity.Account;
import com.example.tatyamyam.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final AccountRepository accountRepository;
	
	public UserDetailsServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Account account = accountRepository.findByEmail(email);
			String userRoleName = account.getEmail();
			Collection<GrantedAuthority> authorities = new ArrayList<>();         
            authorities.add(new SimpleGrantedAuthority(userRoleName));
            return new UserDetailsImpl(account, authorities);
		} catch (Exception e) {
			throw  new UsernameNotFoundException("ユーザーが見つかりませんでした。");
		}
	}

}
