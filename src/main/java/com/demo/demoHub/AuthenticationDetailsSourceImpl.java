/*

 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.demoHub;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;

/**
 *
 * @author admin1
 */
public class AuthenticationDetailsSourceImpl implements AuthenticationDetailsSource<HttpServletRequest, CustomWebAuthenticationDetails>{

    @Override
    public CustomWebAuthenticationDetails buildDetails(HttpServletRequest request) {
        return (new CustomWebAuthenticationDetails(request));
    }
    
}
