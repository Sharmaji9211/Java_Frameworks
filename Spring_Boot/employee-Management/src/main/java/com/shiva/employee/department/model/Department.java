package com.shiva.employee.department.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Department
{
	@Id
	@GeneratedValue(generator =  "department_id")
	@SequenceGenerator(name = "department_id",  initialValue =101, allocationSize=1)
	private int did;
	private String name;
	private String hod;
	private int members;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHod() {
		return hod;
	}
	public void setHod(String hod) {
		this.hod = hod;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	
	
	
}
