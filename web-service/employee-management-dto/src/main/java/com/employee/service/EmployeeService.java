package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;

public interface EmployeeService 
{
	Employee addEmployee(Employee employee);
	EmployeeDto getById(int eid);
	List<Employee> getList();
	boolean isEmployeeExist(int eid);
	void deleteEmployee(int eid);
}
