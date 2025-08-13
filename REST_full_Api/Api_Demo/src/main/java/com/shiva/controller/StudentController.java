package com.shiva.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiva.model.Student_Management;
import com.shiva.service.StudentService;


@Controller
@ResponseBody
public class StudentController 
{
	private StudentService service;
    public StudentController( StudentService service) {
		this.service =service;
		
	}
   @PostMapping("/add")
   public Student_Management addStudent(@RequestBody Student_Management student) {
	service.addStudent(student);   
	return student;
	   
   }
   @GetMapping
   public List<Student_Management> getStudent(){
	   List<Student_Management> list=service.getList();
	   return list;
   }
   @GetMapping("/{Sid}")
   public Student_Management getStudentById(@PathVariable int Sid) {
	   Student_Management student=service.getUserById(Sid);
	   return student;
   }
   @PutMapping("/update/{Sid}")
   public Student_Management updateStudent(@PathVariable int Sid,@RequestBody Student_Management student) {
	   Student_Management existStudent=service.getUserById(Sid);
	   if(existStudent!=null) {
		   student.setSid(Sid);
		   service.updateUser(student);
		   return student;
	   }
	   else 
		   service.addStudent(student);
	   return student;
   }
   @DeleteMapping("/{Sid}")
   public ResponseEntity<Student_Management> deleteStudent(@PathVariable int Sid) {
	   
	   Student_Management student = service.getUserById(Sid);
	   if(student ==null) 
	   {
		   return ResponseEntity.notFound().build();
	   }
	  else{
		  service.deleteStudent(Sid);
		  return ResponseEntity.ok(student);
	  }
   }  
}
