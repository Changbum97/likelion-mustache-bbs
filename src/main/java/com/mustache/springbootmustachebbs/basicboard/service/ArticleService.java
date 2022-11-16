package com.mustache.springbootmustachebbs.basicboard.service;

import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import com.mustache.springbootmustachebbs.basicboard.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto findById(Long id) {
        Article article = articleRepository.findById(id).get();
        return Article.of(article);
    }
}
