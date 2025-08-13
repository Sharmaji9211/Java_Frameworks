package com.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.model.Department;
import com.department.service.DepartmentService;

@RestController
@RequestMapping("/department-api")
public class DepartmentController 
{
	@Autowired private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody Department department)
	{
		System.out.println("POST API");
		Department createdDepartment=departmentService.addDepartment(department);
		return new ResponseEntity<>(createdDepartment,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Department>> getDepartmentList()
	{
		System.out.println("GET API");
		List<Department> departments=departmentService.getList();
		if(!departments.isEmpty())
			return ResponseEntity.ok(departments);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/exist/{did}")
	public Boolean isDidExist(@PathVariable int did)
	{
		System.out.println("Exist by id api of department service called");
		return departmentService.existDepartmentBtId(did);
	}
	@GetMapping("/increase_total_employees/{did}")
	public void increaseTotalEmployeesById(@PathVariable int did)
	{
		departmentService.updateTotalEmployees(did,1);
	}
	@GetMapping("/decrease_total_employees/{did}")
	public void decreaseTotalEmployeesById(@PathVariable int did)
	{
		departmentService.updateTotalEmployees(did,-1);
	}
}
