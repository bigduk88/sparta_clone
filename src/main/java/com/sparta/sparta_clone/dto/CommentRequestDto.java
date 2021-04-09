package com.sparta.sparta_clone.dto;

import lombok.Getter;
import lombok.Setter;

//하기 내용을 담아 컨트롤러 및 서비스 사이에서 정보를 옮긴다.
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