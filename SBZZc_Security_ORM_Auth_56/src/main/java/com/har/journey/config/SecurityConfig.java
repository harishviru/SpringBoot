package com.har.journey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(userDetailsService)
		    .passwordEncoder(bCryptPasswordEncoder);
		
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//URL -->AccessType
		  .antMatchers("/user/register","/user/save","/user/login").permitAll()
		  .antMatchers("/home").permitAll()
		  .antMatchers("/admin").hasAuthority("ADMIN")
		  .antMatchers("/emp").hasAuthority("EMPLOYEE")
		  .antMatchers("/common").hasAnyAuthority("ADMIN","EMPLOYEE")
		  .anyRequest().authenticated()
		
		
		//form Login details
		  .and()
			.formLogin()
			.loginPage("/user/login")  //def: /login, GET
			.loginProcessingUrl("/login") 
			.defaultSuccessUrl("/profile",true)
			.failureUrl("/user/login?error")//def: /login?error
 		  
		//logout details
		  .and()
		  .logout()
		  .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))  
		   .logoutSuccessUrl("/user/login?logout")          //default: /login?logout
		
		//exception details
		   .and()
		   .exceptionHandling()
		   .accessDeniedPage("/denied")
		;
	}
	
}
