package com.study.demotest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;

@SpringBootTest (webEnvironment = WebEnvironment.NONE)
@Transactional
public class StudentControllerTest {

	@Autowired
	private StudentController studentController;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void givenStudentName_ReturnStudent() {
		String name = "Joao";
		
		Student savedStudent = studentRepository.save(new Student(null, name, true, 100));
		
		ResponseEntity<Student> result = studentController.readStudent(name);
		
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		assertThat(result.getBody()).isEqualTo(savedStudent);
	}
	
	
}
