package com.demo.demoHub.model;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // unidirecitonal mapping
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="salary")
	private String salary;
	
	
	@ManyToOne(targetEntity=Company.class)//Join column provides the customized name for the foreign key column
	@JoinColumn(name= "company")  // Here ManyToOne act as the Join column means its a foreign key of the another table pk
	//@OneToOne(cascade=CascadeType.ALL , fetch=FetchType.LAZY)
	//@JoinTable(name  = "emp_comp")// create new mapping
	private Company company;
	
	@ManyToOne(targetEntity=Department.class)
	@JoinColumn(name = "department")
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", company=" + company + ", department="
				+ department + "]";
	}
 
	
	

	
//	public Company getComp() {
//		return comp;
//	}
//
//	public void setComp(Company comp) {
//		this.comp = comp;
//	}
	
}

