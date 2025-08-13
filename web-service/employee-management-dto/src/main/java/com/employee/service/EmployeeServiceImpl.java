package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.department.repository.DepartmentRepository;
import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeDtoMpper;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private DepartmentRepository departmentRepository;
	@Autowired private EmployeeDtoMpper modelMapper;

	public Employee addEmployee(Employee employee) 
	{
		//Code to save employee
		Employee emp=employeeRepository.save(employee);
		//Code to increase total_employee value by 1 in Department object
		int did=employee.getDepartment().getDid();
		departmentRepository.updateTotalEmployee(did,1);
		return emp;
	}

	public EmployeeDto getById(int eid) 
	{
		Employee employee=employeeRepository.findById(eid).orElse(null);
		if(employee==null)
			return null;
		return modelMapper.map(employee);
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
		Employee employee=employeeRepository.findById(eid).orElse(null);
		employeeRepository.deleteById(eid);
		departmentRepository.updateTotalEmployee(employee.getDepartment().getDid(),-1);
	}
}