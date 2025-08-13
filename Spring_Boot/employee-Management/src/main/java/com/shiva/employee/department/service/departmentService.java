package com.shiva.employee.department.service;

import java.util.List;

import com.shiva.employee.department.model.Department;

public interface departmentService {

	Department addDepartment(Department department);

	List<Department> getDepartment();

}
