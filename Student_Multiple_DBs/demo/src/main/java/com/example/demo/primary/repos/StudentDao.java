package com.example.demo.primary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.primary.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	
}
