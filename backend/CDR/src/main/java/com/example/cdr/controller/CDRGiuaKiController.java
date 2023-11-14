package com.example.cdr.controller;

import com.example.cdr.dto.CDRGiuaKiReq;
import com.example.cdr.entity.CDRGiuaKi;
import com.example.cdr.service.CDRGiuaKiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cdr-giua-ki")
@RequiredArgsConstructor
public class CDRGiuaKiController {
    private final CDRGiuaKiService cdrGiuaKiService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCDRGiuaKi(@RequestBody CDRGiuaKiReq cdrGiuaKiReq) {
        cdrGiuaKiService.add(cdrGiuaKiReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCDRGiuaKi(@PathVariable long id, @RequestBody CDRGiuaKiReq updatedCDRGiuaKi) {
        cdrGiuaKiService.update(id, updatedCDRGiuaKi);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteCDRGiuaKi(@PathVariable long id) {
        cdrGiuaKiService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CDRGiuaKi>> getAllCDRGiuaKi() {
        List<CDRGiuaKi> cdrGiuaKis = cdrGiuaKiService.getAllCDRGiuaKi();
        return new ResponseEntity<>(cdrGiuaKis, HttpStatus.OK);
    }
}
