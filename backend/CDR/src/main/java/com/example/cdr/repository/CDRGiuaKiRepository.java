package com.example.cdr.repository;

import com.example.cdr.dto.CDRGiuaKiReq;
import com.example.cdr.entity.CDRGiuaKi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CDRGiuaKiRepository extends JpaRepository<CDRGiuaKi, Long> {

}
