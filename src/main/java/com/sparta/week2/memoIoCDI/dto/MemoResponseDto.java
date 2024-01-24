package com.sparta.week2.memoIoCDI.dto;

import com.sparta.week2.memoIoCDI.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private final Long id;
    private final String username;
    private final String contents;

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
    }

    public MemoResponseDto(Long id, String username, String contents) {
        this.id = id;
        this.username = username;
        this.contents = contents;
    }
}
