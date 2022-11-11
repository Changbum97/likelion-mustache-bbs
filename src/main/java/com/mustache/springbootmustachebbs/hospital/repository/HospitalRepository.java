package com.mustache.springbootmustachebbs.hospital.repository;

import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
