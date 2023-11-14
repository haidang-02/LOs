package com.example.cdr.service.impl;

import com.example.cdr.dto.GradeReq;
import com.example.cdr.entity.Grade;
import com.example.cdr.repository.CDRGiuaKiRepository;
import com.example.cdr.repository.GradeRepository;
import com.example.cdr.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    @RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
        private final GradeRepository gradeRepository;
    private final CDRGiuaKiRepository CDRGiuaKiRepository;

    @Override
    public void add(GradeReq gradeReq) {
        Grade newGrade = new Grade();

        newGrade.setStudent(gradeReq.getStudent());
        gradeRepository.save(newGrade);
    }

    @Override
    public void update(long Id, GradeReq gradeReq) {
        Optional<Grade> optionalGrade = gradeRepository.findById(Id);

        if (optionalGrade.isPresent()) {
            Grade existingGrade = optionalGrade.get();

            existingGrade.setDiemGiuaKiCDR1_2(gradeReq.getDiemGiuaKiCDR1_2());
            existingGrade.setDiemGiuaKiCDR2_1(gradeReq.getDiemGiuaKiCDR2_1());
            existingGrade.setDiemGiuaKiCDR1_2H10(gradeReq.getDiemGiuaKiCDR1_2() / 5 * 10);
            existingGrade.setDiemGiuaKiCDR2_1H10(gradeReq.getDiemGiuaKiCDR2_1() / 5 * 10);
            existingGrade.setDiemGiuaKi(gradeReq.getDiemGiuaKiCDR1_2() +  gradeReq.getDiemGiuaKiCDR2_1());
            existingGrade.setMucDatCDR1_2(existingGrade.getDiemGiuaKiCDR1_2H10() > 4 ? 0 : 1);
            existingGrade.setMucDatCDR2_1(existingGrade.getDiemGiuaKiCDR2_1H10() > 4 ? 0 : 1);


            // Thực hiện các kiểm tra hoặc xử lý trước khi cập nhật, nếu cần
            gradeRepository.save(existingGrade);
        } else {
            throw new RuntimeException("Không tìm thấy điểm với id: " + Id);
        }
    }


    @Override
    public void delete(long Id) {
        Optional<Grade> gradeOptional = gradeRepository.findById(Id);

        if (gradeOptional.isPresent()) {
            Grade existingGrade = gradeOptional.get();
            gradeRepository.delete(existingGrade);
        }
    }

    @Override
    public List<Grade> getAllGrade() {return gradeRepository.findAll();
    }
}
