package com.shiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.model.Employee;
import com.shiva.repository.Repository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private Repository repository;

	@Override
	public void addEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	public Employee getEmployee(int pid) {
		return repository.findById(pid).orElse(null);
	}

	@Override
	public List<Employee> getAllEmp() {
		return repository.findAll();
	}

	@Override
	public void delete(int pid) {
       repository.deleteById(pid);
	}

	@Override
	public void updateEmp(Employee employee) {
	   repository.save(employee);
	}

	@Override
	public void updatepartilly(Employee oldEmployee, Employee newemployee) {
		String name= newemployee.getName();
		int age =  newemployee.getAge();
		if(name!=null) {
			oldEmployee.setName(name);
		}
		if(age!=0) {
			oldEmployee.setAge(age);
		}
	}
}
