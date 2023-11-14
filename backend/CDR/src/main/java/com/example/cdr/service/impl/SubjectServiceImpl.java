package com.example.cdr.service.impl;

import com.example.cdr.dto.SubjectReq;
import com.example.cdr.entity.Subject;
import com.example.cdr.repository.SubjectRepository;
import com.example.cdr.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;


    public void add(SubjectReq subjectReq) {
        Subject newSubject = new Subject();

        newSubject.setName(subjectReq.getName());
        newSubject.setDes(subjectReq.getDes());
        newSubject.setStudents(subjectReq.getStudents());
        newSubject.setCDRGiuaKis(subjectReq.getCDRGiuaKis());

        subjectRepository.save(newSubject);
    }

    public void update(long id, SubjectReq subjectReq){
        Optional<Subject> subjectOptional = subjectRepository.findById(id);

        if (subjectOptional.isPresent()){
            Subject existingSubject = subjectOptional.get();

            existingSubject.setName(subjectReq.getName());
            existingSubject.setDes(subjectReq.getDes());
            existingSubject.setStudents(subjectReq.getStudents());
            existingSubject.setCDRGiuaKis(subjectReq.getCDRGiuaKis());

            subjectRepository.save(existingSubject);
        } else {
            throw new RuntimeException("Không tìm thấy môn học với id: " + id);
        }
    }

    public void delete(long id){
        Optional<Subject> subjectOptional = subjectRepository.findById(id);

        if (subjectOptional.isPresent()){
            Subject existingSubject = subjectOptional.get();
            subjectRepository.delete(existingSubject);
        }
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }
}
