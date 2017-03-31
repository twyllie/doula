package com.doula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	
	@Autowired
    private UserDetailsService userDetailsService;

	
	
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/resources/**", "/preview", "/signup").permitAll()		
				.antMatchers("/u/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/signin").defaultSuccessUrl("/u/home")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/signout")
				.logoutSuccessUrl("/signin?signout")
				.permitAll();
		
	}
	
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	

}
