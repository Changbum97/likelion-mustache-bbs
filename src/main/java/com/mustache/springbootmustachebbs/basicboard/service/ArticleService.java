package com.mustache.springbootmustachebbs.basicboard.service;

import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleAddRequest;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleAddResponse;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import com.mustache.springbootmustachebbs.basicboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto findById(Long id) {
        Article article = articleRepository.findById(id).get();
        return Article.of(article);
    }

    public ArticleAddResponse add(ArticleAddRequest dto) {
        Article article = articleRepository.save(dto.toEntity());
        log.info("article : {}", article);
        ArticleAddResponse articleAddResponse =
                new ArticleAddResponse(article.getId(), article.getTitle(), article.getContent());
        log.info("articleAddResponse : {}", articleAddResponse);
        return articleAddResponse;
    }
}
