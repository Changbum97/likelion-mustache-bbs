package com.mustache.springbootmustachebbs.basicboard.repository;

import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
