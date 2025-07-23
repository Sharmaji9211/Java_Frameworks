package com.employee;
import javax.persistence.*;
@Entity
@Table(name="employeeinfo")
public class Employee 
{
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator= "emp_sequence")
	@SequenceGenerator(name ="emp_sequence",initialValue= 101,allocationSize=1)
	@Column(name="eid")
	private int eid ;
	@Column(name="name", length=40)
	private String name;
	@Column(name="dept" , length=30)
	private String department;
	@Column(name="salary")
	private int salary;
	
	public Employee() {
		
	}

	public Employee(String name, String department, int salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
}
