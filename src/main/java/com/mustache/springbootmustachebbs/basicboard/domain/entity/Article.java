package com.mustache.springbootmustachebbs.basicboard.domain.entity;

import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.hospital.domain.dto.HospitalResponse;
import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @OneToMany(mappedBy = "article")
    private List<Reply> replies = new ArrayList<>();

    public static ArticleDto of(Article article) {
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());
    }
}
