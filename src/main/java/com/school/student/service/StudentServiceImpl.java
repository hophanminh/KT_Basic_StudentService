package com.school.student.service;

import com.school.student.model.dto.StudentDto;
import com.school.student.model.entity.Student;
import com.school.student.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    public List<StudentDto> getListStudent() {
        List<StudentDto> result = new ArrayList<>();
        studentRepo.findAll()
                .forEach(student -> result.add(mapToStudentDto(student)));
        return result;
    }

    private StudentDto mapToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName()).build();
    }
}
