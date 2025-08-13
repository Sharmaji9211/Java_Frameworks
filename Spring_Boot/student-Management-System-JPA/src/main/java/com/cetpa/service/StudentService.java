package com.cetpa.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cetpa.models.Student;
import com.cetpa.repositories.StudentRepository;
@Service
public class StudentService  {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void saveProduct(Student student) {
        studentRepository.save(student);
    }
    public Student getProduct(int sid) {
        return studentRepository.findById(sid).orElse(new Student());
    }
    public void deleteProduct(int sid) {
        studentRepository.deleteById(sid);
    }
    public void updateProduct(Student student) {
        studentRepository.save(student);
    }
    public List<Student> getProducts() {
        return studentRepository.findAll();
    }
	
	
}
