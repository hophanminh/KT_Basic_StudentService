package com.school.student.controller;

import com.school.student.model.request.StudentRequest;
import com.school.student.model.dto.StudentDto;
import com.school.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/students")
@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentDto> getListStudent() {
        return studentService.getListStudent();
    }

    @PostMapping
    public StudentDto createStudent(@Valid @RequestBody StudentRequest request) {
        log.info("Create student in controller: {}", request);
        return studentService.createStudent(request);
    }

    @PutMapping("/{idStudent}")
    public StudentDto updateStudent(@PathVariable String idStudent, @RequestBody StudentRequest request) {
        return studentService.updateStudent(idStudent, request);

    }
}
