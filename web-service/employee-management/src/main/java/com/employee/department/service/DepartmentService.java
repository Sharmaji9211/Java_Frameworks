package com.employee.department.service;

import java.util.List;

import com.employee.department.model.Department;

public interface DepartmentService 
{
	Department addDepartment(Department department);
	List<Department> getList();
}
