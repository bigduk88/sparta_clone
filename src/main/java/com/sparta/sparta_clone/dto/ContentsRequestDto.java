package com.sparta.sparta_clone.dto;

import lombok.Getter;
import java.util.List;

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