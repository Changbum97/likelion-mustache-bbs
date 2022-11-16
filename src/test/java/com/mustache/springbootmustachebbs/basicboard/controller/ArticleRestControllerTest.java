package com.mustache.springbootmustachebbs.basicboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleAddRequest;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleAddResponse;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import com.mustache.springbootmustachebbs.basicboard.service.ArticleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Article 하나를 JSON 형태로 잘 받아오는지 테스트")
    void getArticleTest() throws Exception {

        // articleService.findById(1L)의 결과가 ArticleDto(1L, "111", "수정")과 같은지 확인
        given(articleService.findById(1L)).willReturn(new ArticleDto(1L, "111", "수정"));

        // URL로 request 했을 때 예상하는 결과값이 오는지 확인
        String url = "/api/v1/articles/1";

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("111"))
                .andExpect(jsonPath("$.content").value("수정"))
                .andDo(print());

        // articleService의 findById(1L) 메소드가 실행되었는지 확인
        verify(articleService).findById(1L);
    }

    @Test
    @DisplayName("Article을 잘 추가하는지 테스트")
    void addArticleTest() throws Exception {

        ArticleAddRequest articleAddRequest = new ArticleAddRequest("제목111", "내용111");
        ArticleAddResponse articleAddResponse = new ArticleAddResponse(21L, "제목111", "내용111");

        //given(articleService.add(articleAddRequest)).willReturn(articleAddResponse);
        given(articleService.add(any())).willReturn(articleAddResponse);

        byte[] jsonRequest = objectMapper.writeValueAsBytes(articleAddRequest);
        String url = "/api/v1/articles";

        mockMvc.perform(post(url).content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

         verify(articleService).add(any());
    }
}