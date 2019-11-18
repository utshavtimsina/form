package org.famas.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
CustomAuthenticationProvider authenticationProvider;
@Autowired
CustomAuthenticationSuccessHandler successHandler;
@Autowired
CustomAuthenticationFailureHandler authenticationFailureHandler;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider);
		/*
		auth.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder().encode("")).roles("ADMIN").and()
		.withUser("user").password(passwordEncoder().encode("")).roles("USER");
		*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// TODO Auto-generated method stub
		http.csrf().disable()
			.httpBasic().disable()
			.authorizeRequests()
			.antMatchers("/questionSavePage","/getUserById","/saveQuestionAnswers","/admin","/adminIndividualResults/*").hasAuthority("ROLE_ADMIN")
			.antMatchers("/survey","/").hasAuthority("ROLE_USER")
			//.antMatchers("/getAll").permitAll()
			.antMatchers("/**").permitAll()
			//.antMatchers("/resources/static/**").permitAll()
			.antMatchers("/login","/register").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().successHandler(successHandler)
			.failureHandler(authenticationFailureHandler)
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.and().logout().permitAll();
			
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
