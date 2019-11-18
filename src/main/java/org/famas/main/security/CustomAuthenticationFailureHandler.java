package org.famas.main.security;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.famas.main.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;  
@Configuration
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{
	@Autowired 
	UserDetailsService  userService;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//response.SC_BAD_REQUEST;
		//response.getOutputStream().println("no");
		CustomUserDetails user = (CustomUserDetails) userService.loadUserByUsername(request.getParameter("username"));
		if(user != null) {
			redirectStrategy.sendRedirect(request, response, "/login?error=true");
		}else {
			redirectStrategy.sendRedirect(request, response, "/login?error=true&user=false");
		}
		
	}

}
