package com.example.cdr.service;

import com.example.cdr.dto.CDRGiuaKiReq;
import com.example.cdr.dto.GradeReq;
import com.example.cdr.entity.CDRGiuaKi;

import java.util.List;

public interface CDRGiuaKiService {
    void add(CDRGiuaKiReq CDRGiuaKi);
    void update(long Id, CDRGiuaKiReq updatedCDRGiuaKi);
    void delete(long Id);
    List<CDRGiuaKi> getAllCDRGiuaKi();

}
