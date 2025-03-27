package com.dronezzfly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column(name="employeeid")  //optional
	private long id;
	@Column(name="employeename")
	private String name;
	@Column(name="employeesalary")
	private int salary;
	@Column(name="employeedept")
	private String dept;

}
