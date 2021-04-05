package com.sparta.sparta_clone.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String userId;
    private String comment;
    private Long contentsId;
    private String commentDT;
}
