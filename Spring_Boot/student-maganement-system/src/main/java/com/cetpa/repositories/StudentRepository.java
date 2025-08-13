package com.cetpa.repositories;

import java.util.List;

import com.cetpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository  
{
	void persistObject(Student student);
	Student getRecord(int sid);
	void deleteRecord(Student student);
	void updateRecord(Student ostudent, Student nstudent);
	List<Student> getList();
}
