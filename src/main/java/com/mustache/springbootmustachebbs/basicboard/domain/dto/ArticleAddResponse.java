package com.mustache.springbootmustachebbs.basicboard.domain.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
public class ArticleAddResponse {
    private Long id;
    private String title;
    private String content;
}
