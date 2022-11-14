package com.mustache.springbootmustachebbs.hospital.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;

    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
    }
}
