package com.sparta.week2.memoJpa.repository;

import com.sparta.week2.memoJpa.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {

}