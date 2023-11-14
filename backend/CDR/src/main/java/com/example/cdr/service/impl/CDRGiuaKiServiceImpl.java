package com.example.cdr.service.impl;

import com.example.cdr.dto.CDRGiuaKiReq;
import com.example.cdr.entity.CDRGiuaKi;
import com.example.cdr.repository.CDRGiuaKiRepository;
import com.example.cdr.service.CDRGiuaKiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CDRGiuaKiServiceImpl implements CDRGiuaKiService {
    private final CDRGiuaKiRepository cdrGiuaKiRepository;
    @Override
    public void add(CDRGiuaKiReq cdrGiuaKiReq) {
        CDRGiuaKi newCDRGiuaKi = new CDRGiuaKi();
        newCDRGiuaKi.setName(cdrGiuaKiReq.getName());
        newCDRGiuaKi.setMaxScore(cdrGiuaKiReq.getMaxScore());
        newCDRGiuaKi.setSubject(cdrGiuaKiReq.getSubject());


        cdrGiuaKiRepository.save(newCDRGiuaKi);
    }

    @Override
    public void update(long Id, CDRGiuaKiReq updatedCDRGiuaKi) {
        Optional<CDRGiuaKi> cdrGiuaKiOptional = cdrGiuaKiRepository.findById(Id);

        if (cdrGiuaKiOptional.isPresent()) {
            CDRGiuaKi existingCDRGiuaKi = cdrGiuaKiOptional.get();
            existingCDRGiuaKi.setName(updatedCDRGiuaKi.getName());
            existingCDRGiuaKi.setMaxScore(updatedCDRGiuaKi.getMaxScore());
            existingCDRGiuaKi.setSubject(updatedCDRGiuaKi.getSubject());
            cdrGiuaKiRepository.save(existingCDRGiuaKi);
        } else {
            throw new RuntimeException("Không tìm thấy CDR với id: " + Id);
        }
    }

    @Override
    public void delete(long Id) {
        Optional<CDRGiuaKi> cdrGiuaKiOptional = cdrGiuaKiRepository.findById(Id);

        if (cdrGiuaKiOptional.isPresent()) {
            CDRGiuaKi existingCDRGiuaKi = cdrGiuaKiOptional.get();
            cdrGiuaKiRepository.delete(existingCDRGiuaKi);
        }
    }

    @Override
    public List<CDRGiuaKi> getAllCDRGiuaKi() {
        return cdrGiuaKiRepository.findAll();
    }
}
