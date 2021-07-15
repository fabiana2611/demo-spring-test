package com.study.demotest.repository;

import static org.assertj.core.api.BDDAssertions.then;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;

@DataJpaTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	void testGetObjectByName_ReturnObj() {
		
		// given
		//Student savedStudent = studentRepository.save(new Student(null, "Joao"));
		Student savedStudent = testEntityManager.persistFlushFind(new Student(null, "Joao", true, 0));
		
		// when
		Student student = studentRepository.getStudentByName("Joao");
		
		// then
		then(student.getId()).isNotNull();
		then(student.getName()).isEqualTo(savedStudent.getName());
	}
	
	@Test
	void getAvgGradeForActiveStudents_CalculatesAvg() {
		
		//given
		Student st1 = new Student(null, "joao", true, 80);
		Student st2 = new Student(null, "maria", true, 100);
		Student st3 = new Student(null, "pedro", false, 50);
		Arrays.asList(new Student[] {st1, st2,st3}).forEach(testEntityManager::persistFlushFind);;
		
		//when
		Double avgGrade = studentRepository.getAvgGradeForActiveStudents();
		
		// then
		then(avgGrade).isEqualTo(90);
	}
}
