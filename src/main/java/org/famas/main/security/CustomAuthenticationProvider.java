package org.famas.main.security;

import java.util.ArrayList;
import java.util.List;

import org.famas.main.service.UserDetailsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	 public static final Logger logger = org.slf4j.LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	@Autowired
	UserDetailsService userDetails;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		 String name = authentication.getName();
	     String password = authentication.getCredentials().toString();
	    //logger.info("Custom AUTH CALLED" + authentication.getCredentials());
	 	
	     CustomUserDetails customUserDetails =(CustomUserDetails) userDetails.loadUserByUsername(authentication.getName());
	    //logger.info("username: " + customUserDetails.getUsername());
	  // /* 
	    if(customUserDetails != null) {
	    	if(customUserDetails.getPassword().equals(password)) {
	    		customUserDetails.getUser().setPassword(passwordEncoder.encode(password));
		    	 /*List<GrantedAuthority> grantedAuths = new ArrayList<>();
		    	 grantedAuths.addAll(customUserDetails.getAuthorities());*////*
				return new UsernamePasswordAuthenticationToken(customUserDetails,null, customUserDetails.getAuthorities());
		     }else {
		    	 throw new BadCredentialsException("Invlid credentials");
		     }
	    }else {
	    	throw new BadCredentialsException("Authentication failure");
	    }
	     
	   
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
