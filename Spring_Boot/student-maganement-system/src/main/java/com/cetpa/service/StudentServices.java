package com.cetpa.service;

import java.util.List;

import com.cetpa.models.Student;

public interface StudentServices 
{
	void saveProduct(Student student);
	Student getProduct(int sid);
	void deleteProduct(int sid);
	void updateProduct(Student student);
	List<Student> getProducts();
}
