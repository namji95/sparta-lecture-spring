//package com.sparta.week2.memoquerymethod.repository;
//
//import com.sparta.week2.memoquerymethod.entity.Memo;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface MemoRepository extends JpaRepository<Memo, Long> {
//    List<Memo> findAllByOrderByModifiedAtDesc();
//
//    List<Memo> findAllByUsername(String username);
//}