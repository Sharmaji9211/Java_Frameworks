package com.shiva.service;

import java.util.List;

import com.shiva.model.Student_Management;

public interface StudentService {

	void addStudent(Student_Management student);
	List<Student_Management> getList();
	Student_Management getUserById(int sid);
	void updateUser(Student_Management student);
	void deleteStudent(int sid);

}
