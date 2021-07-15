package com.study.demotest.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;
import com.study.demotest.service.StudentService;

@SpringJUnitConfig
public class StudentServiceTest {

	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentService service;
	
	
	@Test
	void getStudentById_forSavedStudent_isReturned() {
		
		Student student = new Student(1L,"Joao", true, 100);
		
		Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
		
		Student result = service.getStudentById(1L);
		
		assertThat(result.getName()).isNotNull();
		assertThat(result.getName()).isEqualTo("Joao");
		
	}
}
