package com.mustache.springbootmustachebbs.basicboard.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ArticleAddResponse {
    private Long id;
    private String title;
    private String content;
}
