package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		Employee employeeCreated=employeeService.addEmployee(employee);
		return new ResponseEntity<>(employeeCreated,HttpStatus.CREATED);
	}
	@GetMapping("/{eid}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable int eid)
	{
		EmployeeDto employeeDto=employeeService.getById(eid);
		if(employeeDto==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(employeeDto);
	}
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployeeList()
	{
		List<Employee> employees=employeeService.getList();
		if(!employees.isEmpty())
			return ResponseEntity.ok(employees);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/{eid}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int eid)
	{
		if(!employeeService.isEmployeeExist(eid))
			return ResponseEntity.notFound().build();
		employeeService.deleteEmployee(eid);
		return ResponseEntity.ok().build();
	}
}
