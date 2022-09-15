package com.school.student.controller;

import com.school.student.model.dto.StudentDto;
import com.school.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDto> getListStudent() {
        return studentService.getListStudent();
    }
}
