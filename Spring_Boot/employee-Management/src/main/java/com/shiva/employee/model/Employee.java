package com.shiva.employee.model;


import com.shiva.employee.department.model.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(generator = "employee_id")
	@SequenceGenerator(name = "employee_id", initialValue = 101, allocationSize = 1)
	private int eid;
	private String name;
	private int salary;
	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
