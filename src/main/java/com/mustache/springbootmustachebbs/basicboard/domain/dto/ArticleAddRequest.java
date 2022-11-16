package com.mustache.springbootmustachebbs.basicboard.domain.dto;

import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleAddRequest {

    private String title;
    private String content;

    public Article toEntity() {
        Article article = Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
        return article;
    }
}
