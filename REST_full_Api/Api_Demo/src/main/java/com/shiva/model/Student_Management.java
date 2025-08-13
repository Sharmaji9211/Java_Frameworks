package com.shiva.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student_Management 
{
	@Id
	@GeneratedValue(generator = "stu_seruence")
	@SequenceGenerator(name = "stu_sequence",initialValue = 101,allocationSize = 1)
	 private int Sid;
	 private String name;
	 private String course;
	 public int getSid() {
		 return Sid;
	 }
	 public void setSid(int sid) {
		 Sid = sid;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public String getCourse() {
		 return course;
	 }
	 public void setCourse(String course) {
		 this.course = course;
	 }
		
	 
}
