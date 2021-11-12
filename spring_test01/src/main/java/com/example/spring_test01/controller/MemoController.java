package com.example.spring_test01.controller;

import com.example.spring_test01.domain.Memo;
import com.example.spring_test01.dto.MemoDto;
import com.example.spring_test01.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/memo")
    public List<Memo> readMemo() {
        return memoService.findAll();
    }

    @PostMapping("/memo")
    public Memo addMemo(@RequestBody MemoDto memoDto) {
        Memo memo = memoService.createMemo(memoDto);
        return memo;
    }
}
