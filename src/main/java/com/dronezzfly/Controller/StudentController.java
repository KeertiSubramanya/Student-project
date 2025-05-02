package com.dronezzfly.Controller;

import java.util.List;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.RequestDTO.StudentRequestDTO;
import com.dronezzfly.ResponseDTO.StudentResponseDTO;
import com.dronezzfly.model.Student;
import com.dronezzfly.service.StudentService;

@RestController
@RequestMapping ("/student")    // we need to install lombok and git and github
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDTO studentrequestDto) {
		return studentService.saveStudent(studentrequestDto);
		
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent(){
		return studentService.getAllRecords();
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<StudentResponseDTO> updatestudent(@PathVariable Long id, @RequestBody StudentRequestDTO studentrequestDto){
		return studentService.updatestudent(id, studentrequestDto);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deletestudent(@PathVariable Long id){
		return studentService.deleteStudent(id);
	}
	@GetMapping("/{name}")
	public ResponseEntity<List<Student>> getStudentByName(@PathVariable String name){
		return studentService.getStudentByName(name);
		
	}
	@GetMapping("/age/{age}")
	public ResponseEntity<List<Student>> getStudentByAge(@PathVariable Long age){
		return studentService.getStudentByAge(age);
		
	}
	@GetMapping("name/age/{name}/{age}")
	public ResponseEntity<List<Student>> getStudentByNameAndAge(@PathVariable String name,@PathVariable Long age){
		return studentService.getStudentByNameAndAge(name,age);
		
	}
	@GetMapping("name/or/age/{name}/{age}")
	public ResponseEntity<List<Student>> getStudentpathByNameOrAge(@PathVariable  String name,@PathVariable Long age){
		return studentService.getStudentByNameOrAge(name,age);
		
	}
	@GetMapping("name/path/or/age")
	public ResponseEntity<List<Student>> getStudentByNameOrAge(@RequestParam (required=false)String name,@RequestParam(required=false) Long age){
		return studentService.getStudentByNameOrAge(name,age);
		
	}
	@GetMapping("/get/all/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/get/all/students/{name}")
	public ResponseEntity<List<Student>> getAllStudentsname(@PathVariable String name){
		return studentService.getAllStudentsname(name);
	}
}
