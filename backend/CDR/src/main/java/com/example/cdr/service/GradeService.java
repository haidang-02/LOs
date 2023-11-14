package com.example.cdr.service;

import com.example.cdr.dto.GradeReq;
import com.example.cdr.entity.Grade;

import java.util.List;

public interface GradeService {
    void add(GradeReq Grade);
    void update(long Id, GradeReq updatedGrade);
    void delete(long Id);
    List<Grade> getAllGrade();

}
