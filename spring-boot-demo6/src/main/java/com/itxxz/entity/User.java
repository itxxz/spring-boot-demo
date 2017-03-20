package com.itxxz.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;


public class User implements UserDetails {

	
	private static final long serialVersionUID = 5971833651183011247L;
	private String account;
	private String name;
	private String password;
	private String remark;
	
	private String role="";
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (role == null || role.length() == 0) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList("");
		}
		return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getAccount();
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
