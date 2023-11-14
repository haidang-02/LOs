package com.example.cdr.service.impl;

import com.example.cdr.dto.StudentReq;
import com.example.cdr.entity.Student;
import com.example.cdr.repository.StudentRepository;
import com.example.cdr.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void add(StudentReq studentReq) {
        Student student = new Student();
        student.setName(studentReq.getName());
        student.setStudentCode(studentReq.getStudentCode());
        student.setGrades(studentReq.getGrades());

        studentRepository.save(student);
    }

    @Override
    public void updateStudent(long Id, StudentReq updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(Id);

        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setStudentCode(updatedStudent.getStudentCode());
            existingStudent.setGrades(updatedStudent.getGrades());
            studentRepository.save(existingStudent);
        } else {
            throw new RuntimeException("Không tìm thấy sinh viên với id: " + Id);
        }
    }

    @Override
    public void deleteStudent(long Id) {
        Optional<Student> studentOptional = studentRepository.findById(Id);

        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            studentRepository.delete(existingStudent);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


}
