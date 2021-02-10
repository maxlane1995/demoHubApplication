package com.demo.demoHub.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demoHub.dao.EmpRepo;
import com.demo.demoHub.model.Employee;
import com.demo.demoHub.model.Result;
import com.demo.demoHub.service.EmployeeService;

@Service("EmployeeService")
public class EmpServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepo empRepo;
	

	@Override
	public List<Employee> getEmp() {

		List<Employee> list = empRepo.findAll();
		return list;
	}

	@Override
	public Result saveEmp(Employee emp) {
		Result result = new Result();
		Employee emp1 = empRepo.save(emp);
		if(emp1 == null) {
			result.setSuccess(Boolean.FALSE);
			result.setError("NOT SAVED");
			result.setSuccessMessage("USER IS NOT BEING SAVED");
		}else {
			result.setSuccess(Boolean.TRUE);
			result.setSuccessMessage("USER SAVED SUCCESSFULLY");
		}
		return result;
				
	}

	@Override
	public Employee findById(int id) {
		return empRepo.findById(id).get();
		}
	
	@Override
	public Result updateEmp(Employee emp) {
		Employee er = empRepo.findById(emp.getId()).get();
		Result result = new Result();
		if((er != null)) {
			er.setName(emp.getName());
			empRepo.save(er);
			result.setSuccess(Boolean.TRUE);
			result.setError("no error occured");
			result.setSuccessMessage("USER UPDATED SUCCEESSFULLY");
			return result;
		}else {
			result.setSuccess(Boolean.FALSE);
			result.setError("error occured");
			result.setSuccessMessage("USER NOT UPDATED");
			return result;
		}
	}
	@Override
	public Result deleteById(int id) {
		Result result = new Result();
		empRepo.deleteById(id);
		result.setError("nothing");
		result.setSuccess(Boolean.TRUE);
		result.setSuccessMessage("deleted successfully");
		return result;
	}

	}
