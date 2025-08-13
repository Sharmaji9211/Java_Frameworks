package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cetpa.models.Student;
import com.cetpa.repositories.StudentRepository;

@Service
public class StudentService implements StudentServices {
    
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveProduct(Student student) {
        studentRepository.persistObject(student);
    }

    @Override
    public Student getProduct(int sid) {
        return studentRepository.getRecord(sid);
    }

    @Override
    public void deleteProduct(int sid) {
        Student student = studentRepository.getRecord(sid);
        studentRepository.deleteRecord(student);
    }

    @Override
    public void updateProduct(Student student) {
        Student oldStudent = studentRepository.getRecord(student.getSid());
        studentRepository.updateRecord(oldStudent, student);
    }

    @Override
    public List<Student> getProducts() {
        return studentRepository.getList();
    }
}
