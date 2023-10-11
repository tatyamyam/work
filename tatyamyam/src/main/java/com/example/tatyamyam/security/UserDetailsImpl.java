package com.example.tatyamyam.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.tatyamyam.entity.Account;

@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails {
	private final Account account;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Account account, Collection<GrantedAuthority> authorities) {
        this.account = account;
        this.authorities = authorities;
    }
	
	public Account getAccount() {
		return account;
	}
	
	// ハッシュ化済みのパスワードを返す
	@Override
    public String getPassword() {
        return account.getPassword();
    }
	
	//ログイン時に利用するユーザ名(メールアドレス)を返す
	@Override
    public String getUsername() {
        return account.getEmail();
    }
	
	// ロールのコレクションを返す
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    // ユーザーがロックされていなければtrueを返す
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    // ユーザーのパスワードが期限切れでなければtrueを返す
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
 // ユーザーが有効であればtrueを返す
    @Override
    public boolean isEnabled() {
        return account.getEnabled();
    }

    //
	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}	

}
