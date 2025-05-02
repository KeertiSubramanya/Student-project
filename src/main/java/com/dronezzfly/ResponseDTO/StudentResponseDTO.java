package com.dronezzfly.ResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponseDTO {
	
	private long id;    //if we comment the id name and age we will only display the coursename and mobilenumber 
	private String name;
	private int age; 
	private String coursename;
	private int mobilenumber;
}
