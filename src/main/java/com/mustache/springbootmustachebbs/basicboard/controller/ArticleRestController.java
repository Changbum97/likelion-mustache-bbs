package com.mustache.springbootmustachebbs.basicboard.controller;

import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleAddRequest;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleAddResponse;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import com.mustache.springbootmustachebbs.basicboard.repository.ArticleRepository;
import com.mustache.springbootmustachebbs.basicboard.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok().body(articleService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<ArticleAddResponse> addArticle(ArticleAddRequest dto) {
        ArticleAddResponse articleAddResponse = articleService.add(dto);
        return ResponseEntity.ok().body(articleAddResponse);
    }
}
