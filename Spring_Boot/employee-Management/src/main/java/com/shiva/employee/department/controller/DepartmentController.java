package com.shiva.employee.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.employee.department.model.Department;
import com.shiva.employee.department.service.departmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
	@Autowired
	private departmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department){
		
		Department departments =departmentService.addDepartment(department);
		return new ResponseEntity<>(departments,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Department>> getDepartment(){
		List<Department> list = departmentService.getDepartment();
		if(!list.isEmpty())
			return ResponseEntity.ok(list);
		return  ResponseEntity.noContent().build();
		}

}
