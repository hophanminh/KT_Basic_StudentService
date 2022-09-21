package com.school.student.service;

import com.school.student.model.request.StudentRequest;
import com.school.student.model.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getListStudent();

    StudentDto createStudent(StudentRequest request);

    StudentDto updateStudent(String idStudent, StudentRequest request);
}
