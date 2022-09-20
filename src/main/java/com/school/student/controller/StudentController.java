package com.school.student.controller;

import com.school.student.model.StudentRequest;
import com.school.student.model.dto.StudentDto;
import com.school.student.model.entity.Student;
import com.school.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public StudentDto createStudent(@Valid @RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }
}
