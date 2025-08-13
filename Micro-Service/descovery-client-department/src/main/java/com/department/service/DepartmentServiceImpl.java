package com.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.model.Department;
import com.department.repository.DepartmentRepository;

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

	public Boolean existDepartmentBtId(int did) 
	{
		return departmentRepository.existsById(did);
	}

	public void updateTotalEmployees(int did, int n) 
	{
		Department dept=departmentRepository.findById(did).orElse(null);
		dept.setTotalEmployee(dept.getTotalEmployee()+n);
		departmentRepository.save(dept);
	}
}
