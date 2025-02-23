package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.services.StudentService;

 
@WebMvcTest
class MyControllerTest {
    
    @Autowired
    private MockMvc mvc;
 
    @MockitoBean
    private StudentService service;
 
    private Student student;
    
    @BeforeEach
    void setUp() {
        student = Student.getStudent(2100, 1, "Shoyab", "DPS", 12, 100.0);
    }
 
    private List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(student);
        return students;
    }
 
    @Test
    void testFetchAllStudent() throws Exception {
        when(service.allStudents()).thenReturn(getStudents());
        
        mvc.perform(get("/students"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Shoyab"))
           .andExpect(jsonPath("$[0].percentage").value(100.0));
    }
 
    @Test
    void testGetStudentBySchool() throws Exception {
        when(service.studentSchool("DPS")).thenReturn(getStudents());
 
        mvc.perform(get("/student/school").param("name", "DPS"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].school").value("DPS"));
    }
 
    @Test
    void testGetResult() throws Exception {
        when(service.passedFailStudents(true)).thenReturn(getStudents());
 
        mvc.perform(get("/students/result").param("pass", "true"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Shoyab"));
    }
 
    @Test
    void testGetStudentByStandard() throws Exception {
        when(service.studentNumberStd(12)).thenReturn(1);
 
        mvc.perform(get("/students/{standard}/count", 12))
           .andExpect(status().isOk())
           .andExpect(content().string("1"));
    }
 
    @Test
    void testGetStrengthBySchool() throws Exception {
        when(service.schoolStrength("DPS")).thenReturn(50);
 
        mvc.perform(get("/students/strength").param("school", "DPS"))
           .andExpect(status().isOk())
           .andExpect(content().string("50"));
    }
 
    @Test
    void testGetToppers() throws Exception {
        when(service.topFivePercent()).thenReturn(getStudents());
 
        mvc.perform(get("/students/toppers"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Shoyab"))
           .andExpect(jsonPath("$[0].percentage").value(100.0));
    }
 
    @Test
    void testGetTopperByStandard() throws Exception {
        when(service.standardWiseTopper(12)).thenReturn(getStudents());
 
        mvc.perform(get("/students/topper/{standard}", 12).param("school", "DPS"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Shoyab"));
    }
}