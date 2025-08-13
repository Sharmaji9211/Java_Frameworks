package com.shiva.employee.service;

import java.util.List;

import com.shiva.employee.model.Employee;

public interface employeeService {

	Employee addEmployee(Employee employee);

	List<Employee> getEmployee();

	Employee getEmployeeById(int eid);

	void DeleteEmployee(int eid);

	boolean isEmployeeExist(int eid);

}
