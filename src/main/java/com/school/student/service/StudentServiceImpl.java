package com.school.student.service;

import com.school.student.model.StudentRequest;
import com.school.student.model.dto.StudentDto;
import com.school.student.model.entity.Student;
import com.school.student.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

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

    @Override
    public StudentDto createStudent(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .build();
        log.info("Create student in services: {}", request);
        student = studentRepo.save(student);

        return StudentDto.builder()
                .name(student.getName())
                .id(student.getId())
                .build();
    }

    @Override
    public StudentDto updateStudent(String idStudent, StudentRequest request) {
        Student student = studentRepo.findById(Integer.valueOf(idStudent)).get();
        student.setName(request.getName());

        student = studentRepo.save(student);

        return StudentDto.builder()
                .name(student.getName())
                .id(student.getId())
                .build();
    }

    private StudentDto mapToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName()).build();
    }
}
