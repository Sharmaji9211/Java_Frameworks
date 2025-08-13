package com.department.service;

import java.util.List;

import com.department.model.Department;

public interface DepartmentService 
{
	Department addDepartment(Department department);
	List<Department> getList();
	Boolean existDepartmentBtId(int did);
	void updateTotalEmployees(int did, int i);
}
