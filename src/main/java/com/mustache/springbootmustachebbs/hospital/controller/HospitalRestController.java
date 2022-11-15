package com.mustache.springbootmustachebbs.hospital.controller;

import com.mustache.springbootmustachebbs.hospital.domain.dto.HospitalResponse;
import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import com.mustache.springbootmustachebbs.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
@RequiredArgsConstructor
public class HospitalRestController {

    private final HospitalRepository hospitalRepository;

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        // Hospital Entity
        Hospital hospital = optionalHospital.get();

        // DTO
        HospitalResponse hospitalResponse = Hospital.of(hospital);

        // Return은 DTO로
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
