package com.example.cdr.repository;


import com.example.cdr.dto.StudentReq;
import com.example.cdr.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
