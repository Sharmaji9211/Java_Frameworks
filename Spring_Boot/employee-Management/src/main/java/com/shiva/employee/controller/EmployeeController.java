package com.shiva.employee.controller;

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
import com.shiva.employee.model.Employee;
import com.shiva.employee.service.employeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	 @Autowired 
	 private employeeService employeeService;
	 @PostMapping
		public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
		{
			Employee employeeCreated=employeeService.addEmployee(employee);
			return new ResponseEntity<>(employeeCreated,HttpStatus.CREATED);
		}
	 
	 @GetMapping
	 public ResponseEntity<List<Employee>> getEmployee(){
		 List<Employee> employeeList= employeeService.getEmployee();
		 if(!employeeList.isEmpty()) {
			 return ResponseEntity.ok(employeeList); 
		 }
		 return ResponseEntity.noContent().build();		 
 	 }
	 @GetMapping("/{eid}")
	 public ResponseEntity<Employee> getEmployeeById(@PathVariable int eid){
		 Employee employee= employeeService.getEmployeeById(eid);
		 if(employee!=null) {
			 return ResponseEntity.ok(employee); 
		 }
		 return ResponseEntity.noContent().build();		 
 	 }
	 @DeleteMapping("/{eid}")
	 public ResponseEntity<Employee> deleteEmployee(@PathVariable int eid){
		 if(employeeService.isEmployeeExist(eid)) {
			 employeeService.DeleteEmployee(eid);
			 return ResponseEntity.ok().build(); 
		 }
		 return ResponseEntity.noContent().build();		 
 	 }
}
