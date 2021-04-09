package com.sparta.sparta_clone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//하기 내용을 담아 컨트롤러 및 서비스 사이에서 정보를 옮긴다.
@NoArgsConstructor
@Setter
@Getter
public class ContentsLikeDto {
    private int contentsLike;
}
