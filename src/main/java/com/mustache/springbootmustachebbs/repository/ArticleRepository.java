package com.mustache.springbootmustachebbs.repository;

import com.mustache.springbootmustachebbs.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
