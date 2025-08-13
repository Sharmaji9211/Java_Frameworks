package com.shiva.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shiva.employee.department.repository.departmentRepository;
import com.shiva.employee.model.Employee;
import com.shiva.employee.repository.employeeRepository;

@Service
public class employeeServiceimpl implements employeeService {

	@Autowired
    private departmentRepository departmentRepository;

	@Autowired
	private employeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		
		Employee employe1 = employeeRepository.save(employee);
		int did= employee.getDepartment().getDid();
		departmentRepository.updateMebers(did,1);
		return employe1;
	}

	public List<Employee> getEmployee() {
		
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(int eid) {
		
		return employeeRepository.findById(eid).orElse(null);
	}

	public void DeleteEmployee(int eid) {
		

       Employee employee=employeeRepository.findById(eid).orElse(null);
       departmentRepository.deleteById(eid);
		departmentRepository.updateMebers(employee.getDepartment().getDid(),-1);
		
	}

	public boolean isEmployeeExist(int eid) {
		return departmentRepository.existsById(eid);
	}
}
