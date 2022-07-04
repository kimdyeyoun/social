package com.nagaja.admin.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Alias("Admin")
public class Admin implements UserDetails{

	private int adminId;
	private String adminLoginId;
	private String adminLoginPw;
	private String adminType;
	private String adminCreateDate;
	private String adminModifyDate;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return adminLoginPw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return adminLoginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
