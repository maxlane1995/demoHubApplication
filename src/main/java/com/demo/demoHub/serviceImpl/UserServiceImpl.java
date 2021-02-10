package com.demo.demoHub.serviceImpl;

import org.hibernate.engine.jdbc.spi.ResultSetWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.demoHub.dao.UserRepo;
import com.demo.demoHub.dao.UserRoleRepo;
import com.demo.demoHub.model.Result;
import com.demo.demoHub.model.Role;
import com.demo.demoHub.model.User;
import com.demo.demoHub.model.User_Role;
import com.demo.demoHub.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	private static final Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserRoleRepo uRoleRepo;
	
	@Override
	public Result registerUser(User user) {

		Result result = new Result();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User_Role uRole = new User_Role();
		Role role = new Role();
		role.setId(2);

		try {
			String password = encoder.encode(user.getPassword());
			user.setPassword(password);
			User check = userRepo.findByusername(user.getUsername());
			if (check != null) {
				result.setSuccess(Boolean.FALSE);
				result.setSuccessMessage("USERNAME IS ALREADY PRESENT");
			} else {
				User u = userRepo.save(user);
				if (u != null) {
					uRole.setRole(role);
					uRole.setUser(u);
					User_Role urole = uRoleRepo.save(uRole);
					System.out.println("uRole:"+ uRoleRepo.findAll());
					result.setSuccess(Boolean.TRUE);
					result.setSuccessMessage("USER SAVED SUCCESSFULLY");
				} else {
					result.setError("NOT SAVED SUCCESSFULLY");
					result.setSuccess(Boolean.FALSE);
				}
			}
 
		} catch (Exception e) {
			logger.error(e.toString());
			result.setError("NOT SAVED SUCCESSFULLY");
			result.setSuccess(Boolean.FALSE);
		}

		return result;
	}

	public User getByUserName(String username) {
		return userRepo.findByusername(username);
	}

	public Result loginUser(User user) {
		Result result = new Result();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		User b = this.getByUserName(user.getUsername());
		if (b != null) {

			if (b.getUsername().equals(user.getUsername()) && encoder.matches(user.getPassword(), b.getPassword())) {
				result.setSuccess(Boolean.TRUE); // instead of using password matcher method use matcher method inside
													// the Bcrypt class
				result.setSuccessMessage("USER LOGIN SUCCESSFULLY");
			} else {
				result.setError("LOGIN IS UNSUCCESSFULL ");
				result.setSuccess(Boolean.FALSE);
			}
		}
		return result;
	}

	public String passowordMatcher(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	// ResponseEntity<ResultWrapper<T>> s = new ResponseEntity<ResultSetWrapper<T>>;
}
