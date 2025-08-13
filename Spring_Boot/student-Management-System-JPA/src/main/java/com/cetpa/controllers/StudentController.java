package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cetpa.models.Student;
import com.cetpa.service.StudentService;


@Controller
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/insert")
	public String getAddForm() {
		return "add-student-form";
	}
	@PostMapping("/save-record")
	public ModelAndView saveProductRecord(Student student)
	{
		studentService.saveProduct(student);
		ModelAndView modelAndView=new ModelAndView("save-success");
		return modelAndView;
	}
	@GetMapping("/search")
	public String getSearchForm()
	{
		return "search-form";
	}
	@GetMapping("/search-record")
	public ModelAndView searchProductRecord(int sid) {
	    Student student = studentService.getProduct(sid);
	    ModelAndView modelAndView = new ModelAndView();
	    if (student == null) {
	        modelAndView.setViewName("search-form");
	        modelAndView.addObject("msg", "Student record not found");
	        modelAndView.addObject("sid", sid);
	    } else {
	        modelAndView.setViewName("show-record");
	        modelAndView.addObject("student", student); 
	    }
	    return modelAndView;
	}

	@GetMapping("/delete")
	public String getDeleteForm()
	{
		return "delete-form";
	}
	@GetMapping("/confirm-delete")
	public String showProductRecordForDelete(int sid,Model model)
	{
		Student student=studentService.getProduct(sid);
		if(student==null)
		{
			model.addAttribute("sid",sid);
			model.addAttribute("msg","Student record does not exist");
			return "delete-form";
		}
		model.addAttribute("student",student);
		return "confirm-delete";
	}
	@GetMapping("/delete-record")
	public ModelAndView deleteProductRecord(int sid)
	{
		studentService.deleteProduct(sid);
		ModelAndView modelAndView=new ModelAndView("delete-success");
		modelAndView.addObject("sid",sid);
		return modelAndView;
	}
	@GetMapping("/edit-record")
	public String showProductRecordForEdit(int sid,Model model)
	{
		Student student=studentService.getProduct(sid);
		if(student==null)
		{
			model.addAttribute("sid",sid);
			model.addAttribute("msg","Student record does not exist");
			return "edit-form";
		}
		model.addAttribute("student",student);
		return "show-edit-record";
	}
	@GetMapping("/edit")
	public String getEditForm()
	{
		return "edit-form";
	}
	@PostMapping("/update-record")
	public ModelAndView updateProductRecord(Student student)
	{
		studentService.updateProduct(student);
		ModelAndView modelAndView=new ModelAndView("update-success");
		modelAndView.addObject("sid",student.getSid());
		return modelAndView;
	}
	@GetMapping("/student")
	public ModelAndView getProductRecords()
	{
		List<Student> studentList=studentService.getProducts();
		ModelAndView modelAndView=new ModelAndView("student-list");
		modelAndView.addObject("plist",studentList);
		return modelAndView;
	}
	
	
}
