package com.dronezzfly.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.model.Employee;
import com.dronezzfly.repository.EmployeeRepository;
import com.dronezzfly.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	@Autowired
	private EmployeeRepository emprepo;
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		Employee savedEmployee = emprepo.save(employee);  // Example of saving the entity

	    // Return the saved Employee object with HTTP 201 status
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);

	}
}
