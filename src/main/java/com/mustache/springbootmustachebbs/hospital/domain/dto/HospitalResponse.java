package com.mustache.springbootmustachebbs.hospital.domain.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;
}
