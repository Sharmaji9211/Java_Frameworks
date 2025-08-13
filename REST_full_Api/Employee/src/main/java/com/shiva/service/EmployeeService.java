package com.shiva.service;

import java.util.List;

import com.shiva.model.Employee;

public interface EmployeeService {


	void addEmployee(Employee employee);

	Employee getEmployee(int pid);

	List<Employee> getAllEmp();

	void delete(int pid);

	void updateEmp(Employee employee);

	void updatepartilly(Employee oldEmployee, Employee newemployee);

}
