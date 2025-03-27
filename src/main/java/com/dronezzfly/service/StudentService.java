package com.dronezzfly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dronezzfly.model.Student;
import com.dronezzfly.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity<String> saveStudent(Student student) {
		studentRepository.save(student);
		return new ResponseEntity<>("student saved", HttpStatus.CREATED);
	}
}
