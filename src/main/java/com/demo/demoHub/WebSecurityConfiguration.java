package com.demo.demoHub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwt;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user")
//		.password(new BCryptPasswordEncoder().encode("sd"))
//		.roles("USER"); //using this method of authmanagerBuilder we can authenticate user using inmemory or jdbc or ldap.
//		//here we can override the default login page username and password and give role to the user 
//		//we have to create bean to encode the passsword to encode it while authentication.
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
			//.addFilterBefore(filter, beforeFilter)
			.authorizeRequests()   
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		//	.antMatchers("/**").hasRole("USER") 
			                                //this configure method is used to authorize the user or set the permission for user.
			.and()                           
			.csrf().disable()
			.formLogin(); // we also use the basic authentication instead of the formlogin using httpBasic();
			//we write authrequest at first or add filter for it for giving the authorization 
			//antmatcher used to match the pattern and give or setup the permission for the request like if 
			//the request has this url then permitall or has role then add full permisions to them.
	}
	
	
}
