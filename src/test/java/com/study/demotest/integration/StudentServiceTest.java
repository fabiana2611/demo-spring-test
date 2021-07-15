package com.study.demotest.integration;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;
import com.study.demotest.service.StudentService;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest (webEnvironment = WebEnvironment.NONE)
@Transactional
public class StudentServiceTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@DisplayName("Returning savad student from service layer")
	@Test
	void getStudentById_forSavedStudent_isReturned() {
		
		// given
		Student savedStudent = studentRepository.save(new Student(null, "Joao", true, 100));
		
		// when
		Student student = studentService.getStudentById(savedStudent.getId());
		
		// then
		then(student.getName()).isEqualTo("Joao");
		then(student.getId()).isNotNull();
		
	}
}
