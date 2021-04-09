package com.sparta.sparta_clone.dto;

import lombok.Getter;
import java.util.List;

//하기 내용을 담아 컨트롤러 및 서비스 사이에서 정보를 옮긴다.
@Getter
public class ContentsRequestDto {
    String userId;
    String userName;
    String contents;
    String img;
    String myImg;
    String insertDt;

    Long likeCnt;
    List<String> likeId;
}