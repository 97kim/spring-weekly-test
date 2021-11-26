package com.sparta.weeklytestspring.dto;

import com.sparta.weeklytestspring.domain.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ArticleRequestDto {
    private String title;
    private String content;
    private String tags;
}
