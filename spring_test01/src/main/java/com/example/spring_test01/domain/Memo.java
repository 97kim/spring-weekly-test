package com.example.spring_test01.domain;

import com.example.spring_test01.dto.MemoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Memo {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    public Memo(MemoDto memoDto) {
        this.content = memoDto.getContent();
    }
}
