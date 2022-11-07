package com.mustache.springbootmustachebbs.controller;

import com.mustache.springbootmustachebbs.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.domain.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping("/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto form) {
        log.info(form.toString());

        // ArticleDto를 Article로 만들어줌
        Article article = form.toEntity();

        return "articles/new";
    }
}
