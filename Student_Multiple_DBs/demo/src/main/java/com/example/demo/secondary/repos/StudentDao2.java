package com.example.demo.secondary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.secondary.entities.Student;

@Repository
public interface StudentDao2 extends JpaRepository<Student, Integer>{
	
}
