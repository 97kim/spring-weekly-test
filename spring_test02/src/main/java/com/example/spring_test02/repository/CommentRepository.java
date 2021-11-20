package com.example.spring_test02.repository;

import com.example.spring_test02.domain.Article;
import com.example.spring_test02.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleId(Long articleId);
}
