package com.example.StudentSpringBootRestApi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentSpringBootRestApi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
