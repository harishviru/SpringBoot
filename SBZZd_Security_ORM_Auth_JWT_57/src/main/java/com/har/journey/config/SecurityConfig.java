package com.har.journey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.har.journey.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	
	@Autowired
	private SecurityFilter securityFilter;
	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		    .passwordEncoder(pwdEncoder);
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/user/save","/user/login").permitAll()
		    .anyRequest().authenticated()
		    
		    .and()
		    .exceptionHandling()
		    .authenticationEntryPoint(authenticationEntryPoint) //Need to provide for REST call by default only applicable WEB MVC 
		    
		    .and()
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Default : STATEFULL
		    //after 2nd Request We are verifying/validating token in securityFilter
		    .and()
		    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
		;
	}
	
}
