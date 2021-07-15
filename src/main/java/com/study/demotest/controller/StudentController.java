package com.study.demotest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.demotest.domain.Student;
import com.study.demotest.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentService studentService;
	
	
	public StudentController(@Autowired StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping ("/{name}")
	public ResponseEntity<Student> readStudent(@PathVariable String name) {
		Optional<Student> result = Optional.ofNullable(studentService.getStudentByName(name));
		return result.isPresent() 
				? ResponseEntity.ok(result.get())
                : ResponseEntity.notFound().build();
	}

}
