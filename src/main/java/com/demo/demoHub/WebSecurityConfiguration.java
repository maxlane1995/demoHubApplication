package com.demo.demoHub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
					.antMatchers("/authenticate")
					.antMatchers("/empverify")
					.antMatchers("/login");  //This method filter out the Authenticate method and supress the url from spring security
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			//.addFilterBefore(filter, beforeFilter)
//			.httpBasic()
//			.and()
			.authorizeRequests()   
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/authenticate","/register").permitAll()
			.antMatchers("/empverify").permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated() //any method after above would have authenticated
			//.antMatchers(method)
			//	.antMatchers("/**").hasRole("USER")//this configure method is used to authorize the user or set the permission for user.
			
		.and()                           
		
			.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
			//.formLogin()
		//.and()
			 // we also use the basic authentication instead of the formlogin using httpBasic();
			//we write authrequest at first or add filter for it for giving the authorization 
			//antmatcher used to match the pattern and give or setup the permission for the request like if 
			//the request has this url then permitall or has role then add full permisions to them.
	}
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Bean(name="authenticationDetailsSourceImp")
	public AuthenticationDetailsSourceImpl authenticationDetailsSourceImpl() {
		return new AuthenticationDetailsSourceImpl();
	}
	
	
	
	@Bean(name="customSuccessHandler")
	public CustomRequestAuthenticationSuccessHandler customSuccessHandler() {
		return new CustomRequestAuthenticationSuccessHandler();
	}
	
	
	

	@Bean(name="authenticationProcessingFilter")
	public UsernamePasswordAuthenticationFilter authenticationProcessingFilter() throws Exception{
		
		UsernamePasswordAuthenticationFilter filter=new UsernamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManagerBean());
		filter.setAuthenticationDetailsSource(authenticationDetailsSourceImpl());
		filter.setAuthenticationSuccessHandler(customSuccessHandler());
		
		return filter;
	}
	
	@Bean(name="jacksonMapper")
	public ObjectMapper jacksonMapper() {
		return new ObjectMapper();
	}
	
}
