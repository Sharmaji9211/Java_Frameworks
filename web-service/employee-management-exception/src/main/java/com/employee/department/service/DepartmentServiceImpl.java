package com.employee.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.department.model.Department;
import com.employee.department.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired private DepartmentRepository departmentRepository;

	public Department addDepartment(Department department) 
	{
		return departmentRepository.save(department);
	}

	public List<Department> getList() 
	{
		return departmentRepository.findAll();
	}
}
