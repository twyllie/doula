package com.doula;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/preview", "/signup").permitAll()		
				.antMatchers("/u/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/signin")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/signout")
				.logoutSuccessUrl("/signin?signout");
		
	}
}
