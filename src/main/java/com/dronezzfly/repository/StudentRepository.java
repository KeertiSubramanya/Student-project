package com.dronezzfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dronezzfly.model.Student;
@Repository  //optional
public interface StudentRepository extends JpaRepository<Student, Long> {

}
