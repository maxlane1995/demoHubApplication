package com.demo.demoHub.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.demoHub.model.Company;
import com.demo.demoHub.model.Employee;
import com.demo.demoHub.model.Result;
import com.demo.demoHub.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empSer;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping("/")
	public String testApp() {
		return "You got it";
	}

	@RequestMapping(value = "/saveemp", method = RequestMethod.POST)
	public Result saveEmployee(@RequestBody Employee emp) {
		try {
			return empSer.saveEmp(emp);
		} catch (Exception e) {
			System.out.println("exception occured" + e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			logger.error(e.toString());
		}
		return new Result();
	}

	@RequestMapping(value = "/getemp", method = RequestMethod.GET)
	public List<Employee> getEmp() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			list = empSer.getEmp();
			return list;
		} catch (Exception e) {
			System.out.println("show exception");
			return list;
		}
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Employee findById(@PathVariable("id") int id) {
		try {
			return empSer.findById(id);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return new Employee();
	}

	@RequestMapping(value = "/updateemp", method = RequestMethod.PUT)
	public Result updateEmp(@RequestBody Employee emp) {
		try {
			return empSer.updateEmp(emp);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return new Result();
	}

	@RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.DELETE)
	public Result deleteById(@PathVariable("id") int id) {
		try {
			return empSer.deleteById(id);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return new Result();
	}

}
