package com.example.cdr.repository;

import com.example.cdr.dto.GradeReq;
import com.example.cdr.entity.Grade;
import com.example.cdr.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<GradeReq> findByStudent(Student student);
}