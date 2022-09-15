package com.school.student.repository;

import com.school.student.model.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface StudentRepo extends CrudRepository<Student, BigInteger> {
}
