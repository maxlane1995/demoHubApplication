package com.demo.demoHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoHub.model.User_Role;

@Repository
public interface UserRoleRepo extends JpaRepository<User_Role, Integer> {

}
