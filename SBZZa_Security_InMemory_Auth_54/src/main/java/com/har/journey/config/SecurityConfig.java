package com.har.journey.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ram").password("{noop}ram").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("siva").password("{noop}siva").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("jai").password("{noop}jai").authorities("STUDENT");
		
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		//URL -> AccessType
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAuthority("STUDENT")
		.antMatchers("/common").hasAnyAuthority("ADMIN","EMPLOYEE","STUDENT")
		.anyRequest().authenticated()    //remaining URL's
		
		//Form Details
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome", true)
		
		//Logout Details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		
		//Exception Details
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
		
		
	}
	
}
