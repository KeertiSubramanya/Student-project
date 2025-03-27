package com.dronezzfly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dronezzfly.model.Employee;
import com.dronezzfly.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;
	
	public ResponseEntity<Employee> saveEmployee(Employee employee) {
		Employee savedemployee=emprepo.save(employee);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(savedemployee);
	}

}
