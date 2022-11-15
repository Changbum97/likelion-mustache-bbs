package com.mustache.springbootmustachebbs.hospital.controller;

import com.mustache.springbootmustachebbs.hospital.domain.dto.HospitalResponse;
import com.mustache.springbootmustachebbs.hospital.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalRestController.class)
class HospitalRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean   // HospitalService 테스트를 위해 가짜 객체를 쓰겠다 => DB와 상관 없이 테스트 가능
    HospitalService hospitalService;

    @Test
    @DisplayName("1개의 JSON 형태로 Response가 잘 오는지 테스트")
    void jsonResponseTest() throws Exception {
        // 2321을 넘기면 아래의 JSON 결과가 와야됨
        // {"id":2321,"roadNameAddress":"서울특별시 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)",
        // "hospitalName":"노소아청소년과의원","patientRoomCount":0,"totalNumberOfBeds":0,"businessTypeName":"의원",
        // "totalAreaSize":0.0,"businessStatusName":"영업중"}

        // @Builder 어노테이션이 있다면 아래와 같이 builder 패턴을 사용할 수 있음
        HospitalResponse hospitalResponse = HospitalResponse.builder()
                        .id(2321)
                        .roadNameAddress("서울특별시 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)")
                        .hospitalName("노소아청소년과의원")
                        .patientRoomCount(0)
                        .totalNumberOfBeds(0)
                        .businessTypeName("의원")
                        .totalAreaSize(0.0f)
                        .businessStatusName("영업중")
                        .build();

        given(hospitalService.getHospital(2321)).willReturn(hospitalResponse);

        int hospitalId = 2321;
        String url = "/api/v1/hospitals/" + hospitalId;
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hospitalName").exists())  // $는 루트 $아래에 hospitalName이 있어야 함
                .andExpect(jsonPath("$.hospitalName").value("노소아청소년과의원"))
                .andExpect(jsonPath("$.businessTypeName").value("의원"))
                .andDo(print());

        // getHospital() 메소드의 호출이 있었는지 확인
        verify(hospitalService).getHospital(2321);
    }
}