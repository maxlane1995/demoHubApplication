package com.demo.demoHub.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String compName;
	
	@Column(name="address")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", address=" + address + "]";
	}
	
	
	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY ,targetEntity = Employee.class)  ///onetomany act as a Join table means create the another mapping table by default.
//	            //and if we uses the join column with one to many then it put or add the primary key of
//	            // the company id to the employee table column without any reference to employee class.
//	            // its just the unidirectional mapping one company can have multiple employees therefore,
//	            //we take collection interface objects list.
//	@JoinColumn(name="comp_Id")
//	private List<Employee> emp;
//	
//	public List<Employee> getEmp() {
//		return emp;
//	}
//
//	public void setEmp(List<Employee> emp) {
//		this.emp = emp;
//	}

	
}

	

