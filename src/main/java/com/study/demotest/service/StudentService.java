package com.study.demotest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.study.demotest.domain.Student;
import com.study.demotest.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Cacheable("student")
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	@Cacheable("student")
	public Student getStudentByName(String name) {
		return studentRepository.getStudentByName(name);
	}
}
