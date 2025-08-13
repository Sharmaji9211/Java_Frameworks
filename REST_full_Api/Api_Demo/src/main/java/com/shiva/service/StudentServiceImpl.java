package com.shiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.model.Student_Management;
import com.shiva.repository.studentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired private studentRepository repository;
	
	public void addStudent(Student_Management student) {
		repository.save(student);
	}

	public List<Student_Management> getList() {
		List<Student_Management> list = repository.findAll();
		return list;
	}
	public Student_Management getUserById(int sid) {
		Student_Management  student_Management= repository.findById(sid).orElse(null);
		return  student_Management;
	}
	public void updateUser(Student_Management student) {
		repository.save(student);
		
	}
	public void deleteStudent(int sid) {
		repository.deleteById(sid);
		
	}
	

}
