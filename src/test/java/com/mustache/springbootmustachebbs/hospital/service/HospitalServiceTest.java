package com.mustache.springbootmustachebbs.hospital.service;

import com.mustache.springbootmustachebbs.hospital.domain.dto.HospitalResponse;
import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import com.mustache.springbootmustachebbs.hospital.repository.HospitalRepository;
import com.mustache.springbootmustachebbs.user_exercise.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);
    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        // Spring Test가 아니기 때문에 수동으로 DI
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("Business Status Code가 13이면 영업중")
    void runningTest() {

        Hospital runningHospital = Hospital.builder()
                .id(1).businessStatusCode(13).build();

        Mockito.when(hospitalRepository.findById(1))
                .thenReturn(Optional.of(runningHospital));

        HospitalResponse runningHospitalResponse = hospitalService.getHospital(1);
        assertEquals("영업중", runningHospitalResponse.getBusinessStatusName());
    }

    @Test
    @DisplayName("Business Status Code가 3이면 폐업")
    void closedTest() {

        Hospital closedHospital = Hospital.builder()
                .id(1).businessStatusCode(3).build();

        Mockito.when(hospitalRepository.findById(1))
                .thenReturn(Optional.of(closedHospital));

        HospitalResponse closedHospitalResponse = hospitalService.getHospital(1);
        assertEquals("폐업", closedHospitalResponse.getBusinessStatusName());
    }
}