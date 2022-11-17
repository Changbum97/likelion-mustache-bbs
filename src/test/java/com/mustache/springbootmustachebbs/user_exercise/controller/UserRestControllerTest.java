package com.mustache.springbootmustachebbs.user_exercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.springbootmustachebbs.user_exercise.domain.dto.UserAddRequest;
import com.mustache.springbootmustachebbs.user_exercise.domain.dto.UserResponse;
import com.mustache.springbootmustachebbs.user_exercise.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("GET Single User Test")
    void getUserTest() throws Exception {

        UserResponse expectedResponse = UserResponse.builder()
                .id(1L).username("User1").message("1번 회원 조회 성공").build();

        given(userService.findSingleUser(1L)).willReturn(expectedResponse);

        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("User1"))
                .andExpect(jsonPath("$.message").value("1번 회원 조회 성공"))
                .andDo(print());

        verify(userService).findSingleUser(1L);
    }

    @Test
    @DisplayName("GET Wrong Single User Test")
    void getWrongUserTest() throws Exception {
        UserResponse expectedResponse = UserResponse.builder()
                .message("해당 id의 user가 없습니다").build();

        given(userService.findSingleUser(100L)).willReturn(expectedResponse);

        mockMvc.perform(get("/api/v1/users/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.username").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id의 user가 없습니다"))
                .andDo(print());

        verify(userService).findSingleUser(100L);
    }

    @Test
    @DisplayName("POST user Test")
    void addUserTest() throws Exception {

        UserAddRequest request = new UserAddRequest("username11", "123");

        UserResponse expectedResponse = UserResponse.builder()
                .id(1L).username("username11").message("가입이 완료 되었습니다.").build();

        //given(userService.addUser(any())).willReturn(expectedResponse);
        given(userService.addUser(request)).willReturn(expectedResponse);

        byte[] jsonRequest = objectMapper.writeValueAsBytes(request);

        mockMvc.perform(post("/api/v1/users").content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.username").value("username11"))
                .andExpect(jsonPath("$.message").value("가입이 완료 되었습니다."))
                .andDo(print());

        verify(userService).addUser(request);
    }
}