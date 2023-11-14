package com.example.cdr.controller;

import com.example.cdr.dto.GradeReq;
import com.example.cdr.dto.SubjectReq;
import com.example.cdr.entity.Grade;
import com.example.cdr.entity.Subject;
import com.example.cdr.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createSubject(@RequestBody SubjectReq subjectReq){
        subjectService.add(subjectReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateSubject(@PathVariable long id, @RequestBody SubjectReq updatedSubject) {
        subjectService.update(id, updatedSubject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteSubject(@PathVariable long id) {
        subjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Subject>> getAllSubject() {
        List<Subject> subject = subjectService.getAllSubject();
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
}
