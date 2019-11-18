package org.famas.main.security;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	 protected Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		String url = linkRedirectCreator(authentication);
		redirectStrategy.sendRedirect(request, response, url);
	}
	private String linkRedirectCreator(Authentication authentication) {
		for(GrantedAuthority auth: authentication.getAuthorities()) {
			if(auth.getAuthority().equals("ROLE_ADMIN")) {
				return "/admin";
			}else {
				return "/";
			}
		}
		return null;
	}

}
