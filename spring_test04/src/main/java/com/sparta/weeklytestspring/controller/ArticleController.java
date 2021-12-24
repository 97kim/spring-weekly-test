package com.sparta.weeklytestspring.controller;

import com.sparta.weeklytestspring.domain.Article;
import com.sparta.weeklytestspring.dto.ArticleCommentRequestDto;
import com.sparta.weeklytestspring.dto.ArticleRequestDto;
import com.sparta.weeklytestspring.security.UserDetailsImpl;
import com.sparta.weeklytestspring.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public Article setArticle(ArticleRequestDto articleRequestDto, @AuthenticationPrincipal UserDetailsImpl nowUser) throws IOException {
        return articleService.setArticle(articleRequestDto, nowUser);
    }

    @GetMapping("/articles")
    public Page<Article> getArticles(@RequestParam(required = false) String searchTag,
                                     @RequestParam Integer page,
                                     @RequestParam Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return articleService.getArticles(searchTag, pageRequest);
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id){
        return articleService.getArticle(id);
    }


    @PostMapping("/article/comment")
    public void setArticleComment(@RequestBody ArticleCommentRequestDto articleCommentRequestDto){
        articleService.setArticleComment(articleCommentRequestDto);
    }
}
