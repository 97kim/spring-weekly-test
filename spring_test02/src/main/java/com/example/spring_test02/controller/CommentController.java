package com.example.spring_test02.controller;

import com.example.spring_test02.domain.Article;
import com.example.spring_test02.domain.Comment;
import com.example.spring_test02.dto.ArticleDto;
import com.example.spring_test02.dto.CommentDto;
import com.example.spring_test02.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/comment/read")
    public List<Comment> readComment(@RequestParam Long id) {
        System.out.println(id);
        return commentService.findAllByArticleId(id);
    }

    @PostMapping("/comment/save")
    public Comment addComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentService.createComment(commentDto);
        return comment;
    }
}
