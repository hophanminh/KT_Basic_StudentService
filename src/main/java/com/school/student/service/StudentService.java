package com.school.student.service;

import com.school.student.model.StudentRequest;
import com.school.student.model.dto.StudentDto;
import com.school.student.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getListStudent();

    StudentDto createStudent(StudentRequest request);
}
