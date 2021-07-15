package com.study.demotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import static  org.mockito.BDDMockito.given;
import static  org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import java.util.Optional;

import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;
import com.study.demotest.service.StudentService;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class StudentCacheTest {

	@Autowired
	private StudentService service;
	
	@MockBean
	private StudentRepository repository;
	
	@Test
	void getStudentById_forMultipleRequests_isRetrievedFromCache() {
		
		Long id = 123L;
		given(repository.findById(id)).willReturn(Optional.of(new Student(1L,"Joao", true, 100) ));
		
		service.getStudentById(id);
		service.getStudentById(id);
		service.getStudentById(id);
		
		then(repository).should(times(1)).findById(id);
		
	}
}
