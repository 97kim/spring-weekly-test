package com.sparta.weeklytestspring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Tag extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column
    private String tag;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Article article;

    public Tag(String tag, Article article) {
        this.tag = tag;
        this.article = article;
    }
}
