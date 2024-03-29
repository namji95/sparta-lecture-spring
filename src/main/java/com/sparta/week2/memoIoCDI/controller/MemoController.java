//package com.sparta.week2.memoIoCDI.controller;
//
//import com.sparta.week2.memoIoCDI.dto.MemoRequestDto;
//import com.sparta.week2.memoIoCDI.dto.MemoResponseDto;
//import com.sparta.week2.memoIoCDI.service.MemoService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class MemoController {
//// MemoController -> MemoService -> MemoRepository 흐름
//
//    private final MemoService memoService;
//
//    public MemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }
//
//    @PostMapping("/memos")
//    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
//        return memoService.createMemo(requestDto);
//    }
//
//    @GetMapping("/memos")
//    public List<MemoResponseDto> getMemos() {
//        return memoService.getMemos();
//    }
//
//    @PutMapping("/memos/{id}")
//    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
//        return memoService.updateMemo(id, requestDto);
//    }
//
//    @DeleteMapping("/memos/{id}")
//    public Long deleteMemo(@PathVariable Long id) {
//        return memoService.deleteMemo(id);
//    }
//}