package com.example.spring_test02.service;

import com.example.spring_test02.domain.Article;
import com.example.spring_test02.domain.Comment;
import com.example.spring_test02.dto.ArticleDto;
import com.example.spring_test02.dto.CommentDto;
import com.example.spring_test02.repository.ArticleRepository;
import com.example.spring_test02.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public List<Comment> findAllByArticleId(Long articleId) {
        return commentRepository.findAllByArticleId(articleId);
    }

    @Transactional
    public Comment createComment(CommentDto commentDto) {
        Article article = articleRepository.findById(commentDto.getArticleId()).orElseThrow(
                () -> new NullPointerException("해당 id 없음")
        );
        Comment comment = new Comment(commentDto, article);
        commentRepository.save(comment);
        return comment;
    }

}
