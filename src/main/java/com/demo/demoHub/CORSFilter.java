package com.demo.demoHub;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CORSFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String ORIGIN = "Origin";
	     
		   
		     String origin=request.getHeader(ORIGIN);
		      
		        if(request.getHeader(ORIGIN) == null || request.getHeader(ORIGIN).equals("null")){
		                   
		               response.setHeader("Access-Control-Allow-Origin","*");
		               response.setHeader("Access-Control-Allow-Credentials", "true");
		               response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		        }
		        
		        if((request.getRequestURI().substring(request.getContextPath().length()).equalsIgnoreCase("/login") && request.getMethod().equals("POST")) || request.getMethod().equals("GET")||request.getMethod().equals("DELETE")||request.getMethod().equals("PUT")||request.getMethod().equals("POST")){
		            response.setHeader("Access-Control-Allow-Origin","*");
		            response.setHeader("Access-Control-Allow-Credentials", "true");
		            response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		        }
		        
		        if(request.getMethod().equals("OPTIONS")){
		               
		               try{ 
		                     response.setHeader("Access-Control-Allow-Origin","*");
		                     response.setHeader("Access-Control-Allow-Credentials", "true");
		                     response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		                     //response.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With, Authorization");
		                     response.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
		                     response.getWriter().print("OK");
		                     response.getWriter().flush();
		               }catch(IOException e){
		                     e.printStackTrace();
		               } 
		        }else{
		            filterChain.doFilter(request, response);
		        }    
		
	}

}
