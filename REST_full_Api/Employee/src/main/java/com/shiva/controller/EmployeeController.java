package com.shiva.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shiva.model.Employee;
import com.shiva.service.EmployeeService;

@RestController
public class EmployeeController 
{
	private EmployeeService employeeService;
    EmployeeController( EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
	@PostMapping("employee")
	public Employee addEmployee(@RequestBody Employee  employee) {
		employeeService.addEmployee(employee);
		return employee;
	}
	@GetMapping("/employee/{pid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int pid) {
		Employee employee= employeeService.getEmployee(pid);
		if(employee== null) {
			return ResponseEntity.noContent().build();
		}
		 return ResponseEntity.status(HttpStatus.ACCEPTED).body(employee);
	}
	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllEmp(){
		
		List<Employee> employees= employeeService.getAllEmp();
		if(employees== null) {
			return ResponseEntity.noContent().build();
		}
		 return ResponseEntity.ok(employees);
	}
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int pid) {
		
		Employee employee= employeeService.getEmployee(pid);
		if(employee== null) {
			return ResponseEntity.notFound().build();
		}
		 employeeService.delete(pid);
		 return ResponseEntity.ok(employee);
	}
	@PutMapping("/update/{pid}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int pid,  @RequestBody Employee emp) {
		
		Employee employee= employeeService.getEmployee(pid);
		if(employee== null) {
			return ResponseEntity.notFound().build();
		}
		 emp.setPid(pid);
		 employeeService.updateEmp(emp);
		 return ResponseEntity.ok(employee);
	}
	@PatchMapping("/update-partially/{pid}")
	public ResponseEntity<Employee> updatePartilly(@PathVariable int pid, @RequestBody Employee Newemployee){
		Employee OldEmployee = employeeService.getEmployee(pid);
		if(OldEmployee==null) {
			return ResponseEntity.notFound().build();
		}
		Newemployee.setPid(pid);
		employeeService.updatepartilly(OldEmployee, Newemployee);
		return ResponseEntity.ok(OldEmployee);
		
	}
}
