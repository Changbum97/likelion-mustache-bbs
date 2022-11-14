package com.mustache.springbootmustachebbs.hospital.repository;

import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByRoadNameAddressContainsAndHospitalNameContains(String RoadNameAddress, String HospitalName);
    List<Hospital> findByBusinessTypeNameIn(List<String> inClues);
    List<Hospital> findByRoadNameAddressLikeAndBusinessTypeNameIn(String RoadNameAddress, List<String> inClues);
    List<Hospital> findByTotalNumberOfBedsBetween(int min, int max);
    List<Hospital> findByTotalNumberOfBedsGreaterThanEqualAndTotalNumberOfBedsLessThan(int min, int max);
}
