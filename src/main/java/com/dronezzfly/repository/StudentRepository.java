package com.dronezzfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dronezzfly.model.Student;
@Repository  //optional
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByName(String name);		//select * from student where name=?

	List<Student> findByAge(Long age);

	List<Student> findByNameAndAge(String name, Long age);

	List<Student> findByNameOrAge(String name, Long age);

	@Query("SELECT s FROM Student s")
	List<Student> getAllStudentsByQuery();
	
	@Query("SELECT s FROM Student s WHERE s.name=:name" )  //select s from student s where s.name=:name and s.age=:age for the name and age parameter
	List<Student> getAllStudentsByQueryname(String name);

}
