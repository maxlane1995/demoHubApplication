package com.demo.demoHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoHub.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
