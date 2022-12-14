package com.mustache.springbootmustachebbs.basicboard.domain.dto;

import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
