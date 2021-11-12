package com.example.spring_test01.service;

import com.example.spring_test01.domain.Memo;
import com.example.spring_test01.dto.MemoDto;
import com.example.spring_test01.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    public List<Memo> findAll() {
        return memoRepository.findAll();
    }

    public Memo createMemo(MemoDto memoDto) {
        Memo memo = new Memo(memoDto);
        memoRepository.save(memo);
        return memo;
    }

}
