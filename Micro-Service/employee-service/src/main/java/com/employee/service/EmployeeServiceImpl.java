package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.DepartmentNotFoundException;
import com.employee.fiegnclient.DepartmentClient;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private DepartmentClient departmentClient;

	public Employee addEmployee(Employee employee) 
	{
		int did=employee.getDid();
		if(!departmentClient.isDepartmentExist(did))
			throw new DepartmentNotFoundException("Department with id "+did+" not found");
		//Check existence of department id by calling department-api 
		//Code to save employee
		Employee emp=employeeRepository.save(employee);
		//Code to increase total_employee value by 1 in Department object
		departmentClient.increaseEmployees(did);
		return emp;
	}
	public Employee getById(int eid) 
	{
		return employeeRepository.findById(eid).orElse(null);
	}

	public List<Employee> getList() 
	{
		return employeeRepository.findAll();
	}

	public boolean isEmployeeExist(int eid) 
	{
		return employeeRepository.existsById(eid);
	}

	public void deleteEmployee(int eid) 
	{
		Employee employee=getById(eid);
		//Deleting employee object
		employeeRepository.deleteById(eid);
		//Decreasing total employees number by 1
		departmentClient.decreaseEmployees(employee.getDid());
	}
}