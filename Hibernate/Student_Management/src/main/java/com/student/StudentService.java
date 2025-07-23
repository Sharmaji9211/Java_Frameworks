package com.student;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
public class StudentService 
{
	private static StudentRepository repository;
	public StudentService () {
		repository= new StudentRepository();
	}
	public static void addStudent(HttpServletRequest request) {	
		Student student = new Student();
		student.setSid(Integer.parseInt(request.getParameter("sid")));
		student.setName(request.getParameter("name"));
		student.setMobile(request.getParameter("mobile"));
		student.setEmail(request.getParameter("email"));
		student.setCourse(request.getParameter("course"));
		student.setFee(Integer.parseInt(request.getParameter("fee")));
		repository.saveStudent(student);
	}
	public Student searchStudent(String sid) {
		int Studentsid = Integer.parseInt(sid);
		return repository.searchById(Studentsid);
	}
	public List<Student> getAllStudents(){
		return repository.getAllStudent();
	}
	public void DeleteById(String sid) {
		int StudentSid= Integer.parseInt(sid);
		Student student  = repository.searchById(StudentSid);
		 repository.DeteteById(student);
	}
	public void UpdateRecord(HttpServletRequest request) {
	
		int sid = Integer.parseInt(request.getParameter("sid"));
		Student Nstudent= new Student();
		Nstudent.setSid(sid);
		Nstudent.setName(request.getParameter("name"));
		Nstudent.setMobile(request.getParameter("mobile"));
		Nstudent.setEmail(request.getParameter("email"));
		Nstudent.setCourse(request.getParameter("course"));
		Nstudent.setFee(Integer.parseInt(request.getParameter("fee")));
		
		Student Ostudent =  repository.searchById(sid);
		repository.UpdateRecord(Ostudent ,Nstudent);
	}
 }
