package com.study.demotest.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.demotest.DemoTestApplication;
import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoTestApplication.class)
public class EndPointTest {

	private static final String PARAM_QUERY = "joao";
	
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
	private StudentRepository studentRepository;

    
    @Test
    public void shouldRetrieveStudent() throws JsonProcessingException {
    	
    	Student savedStudent = studentRepository.save(new Student(null, PARAM_QUERY, true, 100));

        ResponseEntity<Student> response = restTemplate.getForEntity("/students/" + PARAM_QUERY, Student.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(savedStudent.getId());
    }
}
