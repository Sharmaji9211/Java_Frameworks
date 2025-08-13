package com.employee.dto;

import org.springframework.stereotype.Component;

import com.employee.model.Employee;

@Component
public class EmployeeDtoMpper 
{
	public EmployeeDto map(Employee employee)
	{
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setName(employee.getName());
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setDepartment(employee.getDepartment().getName());
		return employeeDto;
	}
}
