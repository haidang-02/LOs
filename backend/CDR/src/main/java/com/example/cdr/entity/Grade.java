package com.example.cdr.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Double diemGiuaKiCDR1_2;
    private Double diemGiuaKiCDR2_1;
    private Double diemGiuaKi;
    private Double diemGiuaKiCDR1_2H10;
    private Double diemGiuaKiCDR2_1H10;
    private Integer  mucDatCDR1_2;
    private Integer  mucDatCDR2_1;




}
