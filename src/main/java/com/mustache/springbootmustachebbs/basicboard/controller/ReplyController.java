package com.mustache.springbootmustachebbs.basicboard.controller;

import com.mustache.springbootmustachebbs.basicboard.domain.dto.ReplyDto;
import com.mustache.springbootmustachebbs.basicboard.domain.entity.Reply;
import com.mustache.springbootmustachebbs.basicboard.repository.ArticleRepository;
import com.mustache.springbootmustachebbs.basicboard.repository.ReplyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/reply")
public class ReplyController {

    private final ReplyRepository replyRepository;
    private final ArticleRepository articleRepository;

    public ReplyController(ReplyRepository replyRepository, ArticleRepository articleRepository) {
        this.replyRepository = replyRepository;
        this.articleRepository = articleRepository;
    }

    @PostMapping("/{articleId}")
    public String createReply(@PathVariable Long articleId, ReplyDto dto) {
        Reply newReply = new Reply();
        newReply.setWriter(dto.getWriter());
        newReply.setComment(dto.getComment());
        newReply.setArticle(articleRepository.findById(articleId).get());
        replyRepository.save(newReply);
        return "redirect:/articles/" + articleId;
    }

    @GetMapping("/delete/{id}")
    public String deleteReply(@PathVariable Long id) {
        Long articleId = replyRepository.findById(id).get().getArticle().getId();
        replyRepository.deleteById(id);
        return "redirect:/articles/" + articleId;
    }
}
