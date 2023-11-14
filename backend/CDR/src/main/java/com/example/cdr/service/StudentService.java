package com.example.cdr.service;

import com.example.cdr.dto.StudentReq;
import com.example.cdr.entity.Student;

import java.util.List;

public interface StudentService {
    void add(StudentReq student);

    void updateStudent(long Id, StudentReq updatedStudent);

    void deleteStudent(long Id);


    List<Student> getAllStudents();
}
