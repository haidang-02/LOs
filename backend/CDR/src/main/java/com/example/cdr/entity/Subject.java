package com.example.cdr.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String des;

    @ManyToMany
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    @OneToMany(mappedBy = "subject") // "subject" là tên trường trong CDRGiuaKi tham chiếu đến Subject
    private List<CDRGiuaKi> CDRGiuaKis;

//    @ManyToMany
//    @JoinTable(
//            name = "subject_grade",
//            joinColumns = @JoinColumn(name = "subject_id"),
//            inverseJoinColumns = @JoinColumn(name = "grade_id")
//    )
//    private List<Grade> grades;

}
