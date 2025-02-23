package com.example.demo.repos;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.controllers.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	List<Student> findBySchool(String school);
	List<Student> findByPercentageGreaterThan(int score);
	List<Student> findByPercentageLessThan(int score);
	List<Student> findByStd(int std);
	@Query("from Student order by percentage desc limit ?1 ")
	List<Student> findtopFivePercent(int top5);	
	@Query("from Student where std = ?1 order by percentage desc limit 1")
	List<Student> findstandardWiseTopper(int std);
}
