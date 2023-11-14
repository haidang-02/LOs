package com.example.cdr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String studentCode;

    @JsonBackReference
    @OneToMany(mappedBy = "student")
    private List<Grade> grades;
}