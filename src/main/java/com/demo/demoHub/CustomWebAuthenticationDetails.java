/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demoHub;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 *
 * @author admin1
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails{
    
    private static final long serialVersionUID=2012033417540858020L;
    
    private String phonenumber;
    private String pin;
    private String username;
    private String password;

   

	public String getPhonenumber() {
        return phonenumber;
    }

    public String getPin() {
        return pin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.username=request.getParameter("username");
        this.password=request.getParameter("password");
        this.phonenumber=request.getParameter("phonenumber");
        this.pin=request.getParameter("pin");
    
    }
    
}
