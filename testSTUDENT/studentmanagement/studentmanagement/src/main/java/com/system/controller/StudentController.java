package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.entity.Student;
import com.system.services.StudentService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class StudentController {
	
	private StudentService studentservice;

	@Autowired
	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	@GetMapping("/create")
	public String saveStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addstudent" ;	
	}
	
	@PostMapping("/savestudent")
	public String getStatus(@Valid @ModelAttribute("student") Student student, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "addstudent";
		}
		studentservice.saveStudent(student);
		return "redirect:/read";
	}
	
	
	@GetMapping("/read")
	public String displayAllStudent(Model model){
		List<Student> studentlist =studentservice.getAllStudent();
		model.addAttribute("student", studentlist );
		return "display";
	}
	
	
	@PostMapping("/student/delete")
	public String deleteStu(@RequestParam("id") int stuID, Model model) {
		studentservice.deleteStudent(stuID);
		String deleteMessage ="Student succesfully deleated with ID:"+stuID;
		model.addAttribute("message", deleteMessage);
		return "redirect:/read";
	}
	
	
	@GetMapping("/student/update")
	public String updateStu(@RequestParam("id") int id, Model model) {
		Student student =studentservice.findByID(id);
		model.addAttribute("student", student);
		return "updateForm";		
	}
	
	@PostMapping("/saveupdate")
	public String getUpdate(@Valid @ModelAttribute("student") Student student, BindingResult bindresult) {
		System.out.println(bindresult.getAllErrors());
		if(bindresult.hasErrors()) {
			return "updateForm";
		}
		studentservice.updateStudent(student);
		return "redirect:/read";
		
	}

	
}
