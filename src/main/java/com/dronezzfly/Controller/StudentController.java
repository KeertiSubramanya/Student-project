package com.dronezzfly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.model.Student;
import com.dronezzfly.service.StudentService;

@RestController
@RequestMapping ("/student")    // we need to install lombok and git and github
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
		
	}

}
