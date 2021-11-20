package com.example.spring_test02.controller;

import com.example.spring_test02.domain.Article;
import com.example.spring_test02.dto.ArticleDto;
import com.example.spring_test02.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/read")
    public List<Article> readArticle() {
        return articleService.findAll();
    }

    @PostMapping("/save")
    public Article addArticle(@RequestBody ArticleDto articleDto) {
        Article article = articleService.createArticle(articleDto);
        return article;
    }

    @GetMapping("/comment")
    public Article readArticle(@RequestParam Long id) {
        return articleService.findById(id);
    }
}
