package com.mustache.springbootmustachebbs.hospital.repository;

import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("경기도 수원시의 피부과를 잘 찾는지 Test")
    void Test1() {
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContainsAndHospitalNameContains("경기도 수원시", "피부과");
        for(Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName() + " : " + hospital.getRoadNameAddress());
        }
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소, 보건지소, 보건복지소인 데이터를 잘 찾는지 Test")
    void Test2() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건복지소");

        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for(Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName() + " : " + hospital.getBusinessTypeName());
        }
    }

    @Test
    @DisplayName("주소 + 업태구분명으로 데이터 검색 Test")
    void Test3() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건복지소");

        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressLikeAndBusinessTypeNameIn("%수원%", inClues);
        for(Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName() + " : " + hospital.getRoadNameAddress() +" : " + hospital.getBusinessTypeName());
        }
    }

    @Test
    @DisplayName("병상수가 10개 이상 20개 미만인 병원 검색 Test")
    void Test4() {
        //List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10, 19);
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsGreaterThanEqualAndTotalNumberOfBedsLessThan(10, 20);
        for(Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName() + " : " + hospital.getTotalNumberOfBeds());
        }
    }

    @Test
    @DisplayName("입원실 수 기준으로 내림차순 정렬 Test")
    void Test5() {
        List<Hospital> hospitals = hospitalRepository.findAllByOrderByPatientRoomCountDesc();
        for(Hospital hospital : hospitals) {
            System.out.println(hospital.getHospitalName() + " : " + hospital.getPatientRoomCount());
        }
    }
}