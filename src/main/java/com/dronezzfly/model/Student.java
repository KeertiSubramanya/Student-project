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
@Table(name="studentinfo")  //optional
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column(name="studentid")  //optional
	private long id;
	@Column(name="studentname")
	private String name;
	@Column(name="studentage")
	private int age; 
	
	//getters and setters
	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
}
