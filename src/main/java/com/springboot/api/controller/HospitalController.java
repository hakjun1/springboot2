package com.springboot.api.controller;


import com.springboot.api.dao.HospitalDao;
import com.springboot.api.domain.Hospital;
import com.springboot.api.domain.User;
import com.springboot.api.domain.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    private final HospitalDao hospitalDao;

    @Autowired
    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Hospital> get(@PathVariable Integer id) {
//        Hospital hospital = hospitalDao.findbyId(id);
//        Optional<Hospital> opt = Optional.of(hospital);
//
//        if (!opt.isEmpty()) {
//            return ResponseEntity.ok().body(hospital);
//        } else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
//
//        }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable Integer id) {
        try {
            Hospital hospital = this.hospitalDao.findbyId(id);
            return ResponseEntity
                    .ok()
                    .body(hospital);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




