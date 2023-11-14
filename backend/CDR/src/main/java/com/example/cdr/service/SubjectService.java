package com.example.cdr.service;

import com.example.cdr.dto.SubjectReq;
import com.example.cdr.entity.Subject;

import java.util.List;

public interface SubjectService {
    void add(SubjectReq subject);
    void update(long id, SubjectReq subject);
    void delete(long id);
    List<Subject> getAllSubject();

}
