package com.mustache.springbootmustachebbs.hospital.controller;

import com.mustache.springbootmustachebbs.hospital.domain.dto.HospitalResponse;
import com.mustache.springbootmustachebbs.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalService hospitalService;

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        return ResponseEntity.ok().body(hospitalService.getHospital(id));
    }
}
