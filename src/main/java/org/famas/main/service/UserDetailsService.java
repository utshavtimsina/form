package org.famas.main.service;

import org.famas.main.repo.FormRepo;
import org.famas.main.security.CustomUserDetails;
import org.jdbi.v3.core.Jdbi;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
	Jdbi jdbi;
	FormRepo repo;
	public UserDetailsService(Jdbi jdbi) {
		this.jdbi = jdbi;
		this.repo = jdbi.onDemand(FormRepo.class);
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails user =repo.loadUserByUsername(username);
		return user;
	}
}
