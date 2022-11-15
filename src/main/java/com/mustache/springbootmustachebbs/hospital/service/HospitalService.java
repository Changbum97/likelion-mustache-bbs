package com.mustache.springbootmustachebbs.hospital.service;

import com.mustache.springbootmustachebbs.hospital.domain.dto.HospitalResponse;
import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import com.mustache.springbootmustachebbs.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);

        // Hospital Entity
        Hospital hospital = optionalHospital.get();

        // DTO
        HospitalResponse hospitalResponse = Hospital.of(hospital);

        // 입력된 business Status Cdoe를 String 형태로 변환
        int businessStatusCode = hospital.getBusinessStatusCode();
        String businessStatusName = String.valueOf(businessStatusCode);

        if(businessStatusCode == 13) {
            businessStatusName = "영업중";
        } else if(businessStatusCode == 3) {
            businessStatusName = "폐업";
        }
        hospitalResponse.setBusinessStatusName(businessStatusName);


        return hospitalResponse;
    }
}
