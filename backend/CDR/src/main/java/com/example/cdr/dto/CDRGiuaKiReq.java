package com.example.cdr.dto;

import com.example.cdr.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CDRGiuaKiReq {
    private Long id;
    private String name;
    private String maxScore;
    private Subject subject;
}
