package com.demo.demoHub.service;

import java.util.List;

import com.demo.demoHub.model.Employee;
import com.demo.demoHub.model.Result;

public interface EmployeeService {
	public List<Employee> getEmp();
	
	public Result saveEmp(Employee emp);
	
	public Employee findById(int id);

	public Result updateEmp(Employee emp);

	public Result deleteById(int id);
}
