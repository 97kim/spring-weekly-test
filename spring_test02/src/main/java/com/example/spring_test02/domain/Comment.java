package com.example.spring_test02.domain;

import com.example.spring_test02.dto.CommentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ARTICLE_ID", nullable = false)
    private Article article;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentDto commentDto, Article article) {
        this.comment = commentDto.getComment();
        this.article = article;
    }
}
