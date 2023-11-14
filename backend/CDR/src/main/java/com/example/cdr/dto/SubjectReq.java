package com.example.cdr.dto;

import com.example.cdr.entity.CDRGiuaKi;
import com.example.cdr.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectReq {
    private Long id;
    private String name;
    private String des;
    private List<Student> students;
    private List<CDRGiuaKi> CDRGiuaKis;

}
