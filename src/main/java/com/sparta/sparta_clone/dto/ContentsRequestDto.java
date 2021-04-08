package com.sparta.sparta_clone.dto;

import lombok.Getter;
import org.hibernate.mapping.Array;

import java.util.ArrayList;

@Getter
public class ContentsRequestDto {
    String userId;
    String userName;
    String contents;
    String img;
    String myImg;
    String insertDt;

    Long likeCnt;
    ArrayList likeId;
}
