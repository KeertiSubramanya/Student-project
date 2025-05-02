package com.dronezzfly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dronezzfly.RequestDTO.StudentRequestDTO;
import com.dronezzfly.ResponseDTO.StudentResponseDTO;
import com.dronezzfly.model.Student;
import com.dronezzfly.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public ResponseEntity<StudentResponseDTO> saveStudent(StudentRequestDTO studentrequestDto) {
		
		Student student= new Student();
		student.setName(studentrequestDto.getName());
		student.setAge(studentrequestDto.getAge());
		
		
		Student studentsaved=studentRepository.save(student);    //insert into table values(1,"sujan",7)
		
		StudentResponseDTO responseDto=new StudentResponseDTO();
		responseDto.setId(studentsaved.getId());
		responseDto.setName(studentsaved.getName());
		responseDto.setAge(studentsaved.getAge());
		responseDto.setCoursename("Java");		
		responseDto.setMobilenumber(675788333);
		
		
		return new ResponseEntity<StudentResponseDTO>(responseDto, HttpStatus.CREATED);
	}
	
//	public List<Student> getAllRecords(){
//		//List<Student>  retieverecords=studentRepository.findAll();
//		return studentRepository.findAll();
//	}
	public ResponseEntity<List<Student>> getAllRecords(){
		List<Student>  retrieverecords=studentRepository.findAll();
		return new ResponseEntity<List<Student>>(retrieverecords, HttpStatus.CREATED);
	}

	public ResponseEntity<StudentResponseDTO> updatestudent(Long id, StudentRequestDTO studentrequestDto) {
		Optional<Student> isavailable= studentRepository.findById(id);
		if(isavailable.isPresent()) {
			Student student=isavailable.get();
			student.setAge(studentrequestDto.getAge());
			student.setName(studentrequestDto.getName());
			Student updatedstudent=studentRepository.save(student);
			
			StudentResponseDTO respo=new StudentResponseDTO();
			respo.setId(updatedstudent.getId());
			respo.setName(updatedstudent.getName());
			respo.setAge(updatedstudent.getAge());
			respo.setCoursename("python");
			respo.setMobilenumber(988847);
		
		return new ResponseEntity<StudentResponseDTO>(respo,HttpStatus.OK);
		
		}
	
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Void> deleteStudent(Long id) {
		Optional<Student> isavailable = studentRepository.findById(id);
		if(isavailable.isPresent()) {
		   studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.CONFLICT);	//httpstatus.ok
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		
	}


	public ResponseEntity<List<Student>> getStudentByName(String name) {
		List<Student> student=studentRepository.findByName(name);
		if(student.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	public ResponseEntity<List<Student>> getStudentByAge(Long age) {
		List<Student> student=studentRepository.findByAge(age);
		if(student.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(student,HttpStatus.OK);	}

	public ResponseEntity<List<Student>> getStudentByNameAndAge(String name, Long age) {
		List<Student> student=studentRepository.findByNameAndAge(name,age);
		if(student.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(student,HttpStatus.OK);	}

	public ResponseEntity<List<Student>> getStudentByNameOrAge(String name, Long age) {
		List<Student> student=studentRepository.findByNameOrAge(name,age);
		if(student.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(student,HttpStatus.OK);
}

	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> listofstudents=studentRepository.getAllStudentsByQuery();
		return new ResponseEntity<List<Student>>(listofstudents,HttpStatus.CREATED);
	}

	public ResponseEntity<List<Student>> getAllStudentsname(String name) {
		List<Student> listofstudents=studentRepository.getAllStudentsByQueryname(name);
		return new ResponseEntity<List<Student>>(listofstudents,HttpStatus.CREATED);
	}
}