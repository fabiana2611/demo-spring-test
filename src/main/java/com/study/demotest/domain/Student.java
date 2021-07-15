package com.study.demotest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;

@Entity
@Builder
public class Student {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private boolean active;
	private int grade;
	
	public Student() {}
	
	public Student(Long id, String name, boolean active, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.grade = grade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
