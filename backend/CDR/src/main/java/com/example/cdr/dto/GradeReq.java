package com.example.cdr.dto;

import com.example.cdr.entity.CDRGiuaKi;
import com.example.cdr.entity.Student;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeReq {
    private Long id;

    private Student student;

    private CDRGiuaKi CDRGiuaKi;

    private Double diemGiuaKiCDR1_2;
    private Double diemGiuaKiCDR2_1;
    private Double diemGiuaKi;
    private Double diemGiuaKiCDR1_2H10;
    private Double diemGiuaKiCDR2_1H10;
    private Integer  mucDatCDR1_2;
    private Integer  mucDatCDR2_1;


}
