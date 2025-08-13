package com.employee.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.department.model.Department;
import com.employee.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
	@Autowired private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department department)
	{
		Department createdDepartment=departmentService.addDepartment(department);
		return new ResponseEntity<>(createdDepartment,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Department>> getDepartmentList()
	{
		List<Department> departments=departmentService.getList();
		if(!departments.isEmpty())
			return ResponseEntity.ok(departments);
		return ResponseEntity.noContent().build();
	}
	
}
