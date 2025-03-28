package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controllers.Teacher;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer>{

}
