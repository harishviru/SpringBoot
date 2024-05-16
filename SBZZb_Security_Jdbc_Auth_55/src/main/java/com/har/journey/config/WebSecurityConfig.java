package com.har.journey.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dsSource;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private static final String SQL_1_USERS_BY_USERNAME_QUERY="SELECT username,password,enabled FROM USER_TAB  where username=?";
	private static final String SQL_2_AUTHORITIES_BY_USERNAMEQ_UERY="SELECT username,role FROM USER_TAB  where username=?";
	
	
	//#01. Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
		        .dataSource(dsSource)
		        .usersByUsernameQuery(SQL_1_USERS_BY_USERNAME_QUERY)
		        .authoritiesByUsernameQuery(SQL_2_AUTHORITIES_BY_USERNAMEQ_UERY)
		        .passwordEncoder(passwordEncoder)
		        ;
				
	}
	
	
	//#02. Authorization
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
		
		         //logout details
                 .and()
                 .logout()
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                 
                 //execption details
                 .and()
                 .exceptionHandling()
                 .accessDeniedPage("/denied")
				;
	}
	
	
	
}
