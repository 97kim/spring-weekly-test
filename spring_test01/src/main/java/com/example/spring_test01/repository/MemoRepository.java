package com.example.spring_test01.repository;

import com.example.spring_test01.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, String> {
}
