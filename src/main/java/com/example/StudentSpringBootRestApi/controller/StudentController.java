package com.example.StudentSpringBootRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentSpringBootRestApi.entity.Student;
import com.example.StudentSpringBootRestApi.respository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		List<Student> students=  studentRepository.findAll();
		return students;
		
		}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student=studentRepository.findById(id).get();
		
		return student;
		
	}
@PostMapping("/student/add")
@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
	studentRepository.save(student);
		
	}
	
@DeleteMapping("/students/delete/{id}")
public void removeStudent(@PathVariable int id) {
	Student student= studentRepository.findById(id).get();
	studentRepository.delete(student);
}
}
