package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetAllMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;



@RestController
@RequestMapping("/") // Base URL for all endpoints in this controller
public class HomeController 
{
	@Autowired
	private StudentRepository studentRepository;
	@GetMapping("/index")// "/" acces deault url
	public String index()
	{
		return " Welcome tospring boot CRUD application!!! ";
		
	}
	
	@PostMapping("/save")
	public Student saveData(@RequestBody Student student)
	{
		studentRepository.save(student);
		return student;
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAll()
	{
		List<Student> studentList=studentRepository.findAll();
		return studentList;
	}
}
