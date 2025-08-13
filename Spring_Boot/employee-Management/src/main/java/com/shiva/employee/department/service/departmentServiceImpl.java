package com.shiva.employee.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.employee.department.model.Department;
import com.shiva.employee.department.repository.departmentRepository;

@Service
public class departmentServiceImpl implements departmentService
{
	@Autowired
	private departmentRepository departmentRepository;
	public Department addDepartment(Department department) {
	    
		return departmentRepository.save(department);
	}
	public List<Department> getDepartment() {
		
		return departmentRepository.findAll();
	}
}
