package com.mustache.springbootmustachebbs.basicboard.controller;

import com.mustache.springbootmustachebbs.basicboard.repository.ArticleRepository;
import com.mustache.springbootmustachebbs.basicboard.domain.dto.ArticleDto;
import com.mustache.springbootmustachebbs.basicboard.domain.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping(value = {"", "/"})
    public String home() {
        return "redirect:/articles/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "basicboard/articles/list";
    }

    @GetMapping("/new")
    public String newArticleForm() {
        return "basicboard/articles/new";
    }

    @PostMapping("")
    public String createArticle(ArticleDto form) {
        // ArticleDto를 Article로 만들어줌
        Article article = form.toEntity();
        Article savedArticle = articleRepository.save(article);

        return "redirect:/articles/" + savedArticle.getId();
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if(optArticle.isEmpty()) {
            return "error";
        }

        model.addAttribute("article", optArticle.get());
        model.addAttribute("replies", optArticle.get().getReplies());
        return "basicboard/articles/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if(optArticle.isEmpty()) {
            model.addAttribute("message", id + "가 없습니다");
            return "error";
        }

        model.addAttribute("article", optArticle.get());
        return "basicboard/articles/edit";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, ArticleDto articleDto){
        articleRepository.save(articleDto.toEntity());
        return "redirect:/articles/" + id;
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        articleRepository.deleteById(id);
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("alertMessage", id + "번 글 삭제 완료");
        return "basicboard/articles/list";
        //return "redirect:/articles/list";
    }
}
