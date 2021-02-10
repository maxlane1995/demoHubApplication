package com.demo.demoHub.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "deptname")
	private String name;
	
	@Column(name = "floar")
	private int floar;

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

	public int getFloar() {
		return floar;
	}

	public void setFloar(int floar) {
		this.floar = floar;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", floar=" + floar + "]";
	}
	
	
}
