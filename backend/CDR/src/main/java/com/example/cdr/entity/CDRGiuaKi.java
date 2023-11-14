package com.example.cdr.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CDRGiuaki")
public class CDRGiuaKi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String maxScore;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
