package com.demo.demoHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoHub.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	User findByusername(String username);

}
