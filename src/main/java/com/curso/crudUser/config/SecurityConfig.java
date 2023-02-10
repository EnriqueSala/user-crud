package com.curso.crudUser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Jorge").password("test123").roles("CUSTOMER"))
			.withUser(users.username("Enrique").password("test123").roles("USER"))
			.withUser(users.username("Miguel").password("test123").roles("USER", "MANAGER"))
			.withUser(users.username("Patrobas").password("test123").roles("USER", "ADMIN"));
		
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// secures all REST endpoints under "/api/users"
				// and adds following security authorizations
				// 
				//
				// CUSTOMER role can perform following 
				// 1. Get a single user.  GET /api/users/{userId}
				//
				// EMPLOYEE role can perform following 
				// 1. Get a list of all users.  GET /api/users
				// 2. Get a single user.  GET /api/users/{userId}
				
				//
				// MANAGER role can perform following 
				// 1. Add a new user.  POST /api/users
				// 2. Update an existing user.  PUT /api/users
				//
				
				//
				// ADMIN role can perform following 
				// 1. Delete a user.  DELETE /api/users/{userId}
				//
				
				http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/users").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("EMPLOYEE", "CUSTOMER")
				.antMatchers(HttpMethod.POST, "/api/users").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.POST, "/api/users/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyRole("MANAGER", "ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
				.and()
				.httpBasic()
				.and()
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
	
}
