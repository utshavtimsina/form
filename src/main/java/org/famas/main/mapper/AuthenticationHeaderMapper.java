package org.famas.main.mapper;

import java.util.List;

import org.famas.main.model.UserDto;

public class AuthenticationHeaderMapper {
	private UserDto user;
	private List<String> authorities;
	private Boolean enabled;
	private String password;
	private Boolean accountNonExpired;
	private Boolean credentialsNonExpired;
	private Boolean accountNonLocked;
	private String username;
	
	public AuthenticationHeaderMapper() {
		// TODO Auto-generated constructor stub
	}

	public AuthenticationHeaderMapper(UserDto user, List<String> authorities, Boolean enabled, String password,
			Boolean accountNonExpired, Boolean credentialsNonExpired, Boolean accountNonLocked, String username) {
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.username = username;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	

	
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
