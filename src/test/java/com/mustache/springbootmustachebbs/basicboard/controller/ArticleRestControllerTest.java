package com.mustache.springbootmustachebbs.basicboard.controller;

import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.basicboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleRepository articleRepository;

    @Test
    @DisplayName("Article 하나를 JSON 형태로 잘 받아오는지 테스트")
    void getArticleTest() throws Exception {

        // URL로 request 했을 때 예상하는 결과값이 오는지 확인
        String url = "/api/v1/articles/1";
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("111"))
                .andExpect(jsonPath("$.content").value("수정"))
                .andDo(print());
    }
}