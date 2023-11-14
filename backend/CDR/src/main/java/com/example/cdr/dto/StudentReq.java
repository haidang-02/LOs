package com.example.cdr.dto;

import com.example.cdr.entity.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentReq {
    private Long id;
    private String name;
    private String studentCode;
    private List<Grade> grades;

}
