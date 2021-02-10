package com.demo.demoHub.service;

import com.demo.demoHub.model.Result;
import com.demo.demoHub.model.User;

public interface UserService {

	public Result registerUser(User user);

	public Result loginUser(User user);
}
 