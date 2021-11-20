package com.example.spring_test02.service;

import com.example.spring_test02.domain.Article;
import com.example.spring_test02.domain.Comment;
import com.example.spring_test02.dto.ArticleDto;
import com.example.spring_test02.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Transactional
    public Article createArticle(ArticleDto articleDto) {
        Article article = new Article(articleDto);
        articleRepository.save(article);
        return article;
    }

    public Article findById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 id 없음")
        );
        return article;
    }

}
