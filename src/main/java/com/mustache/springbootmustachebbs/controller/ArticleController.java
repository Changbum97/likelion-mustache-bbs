package com.mustache.springbootmustachebbs.controller;

import com.mustache.springbootmustachebbs.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.domain.entity.Article;
import com.mustache.springbootmustachebbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    // Spring이 DI 해주는 구간
    // ArticleRepository는 interface이지만 그 구현체를 SpringBoot가 넣어줌
    private final ArticleRepository articleRepository;
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/posts")
    public String createArticle(ArticleDto form) {
        log.info(form.toString());

        // ArticleDto를 Article로 만들어줌
        Article article = form.toEntity();

        Article savedArticle = articleRepository.save(article);
        log.info(savedArticle.toString());

        return "articles/new";
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if(optArticle.isEmpty()) {
            return "error";
        }

        model.addAttribute("article", optArticle.get());
        return "articles/show";
    }
}
