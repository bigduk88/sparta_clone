package com.sparta.sparta_clone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private String UserId;
    private Long contentsId;
    private String userName;
    private String comment;
    private String myImg;
    private String commentDt;

}