package com.cetpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Person 
{
	
	@Id
	@GeneratedValue
	private int pid;
	private String name;
	private String phone;
	private String city;
	
	public Person() {
			
		}

	public Person(String name, String phone, String city) {
		super();
		this.pid = pid;
		this.name = name;
		this.phone = phone;
		this.city = city;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", phone=" + phone + ", city=" + city + "]";
	}
	
	
}
