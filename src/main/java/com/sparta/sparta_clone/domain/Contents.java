package com.sparta.sparta_clone.domain;

import com.sparta.sparta_clone.dto.ContentsLikeDto;
import com.sparta.sparta_clone.dto.ContentsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Contents extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String insertDt;

    @Column(nullable = false)
    private int contentsLike;

    // Contents Dto 생성자
    public Contents(ContentsRequestDto contentsRequestDto) {
        this.userId = contentsRequestDto.getUserId();
        this.contents = contentsRequestDto.getContents();
        this.img = contentsRequestDto.getImg();
        this.insertDt = contentsRequestDto.getInsertDt();
        this.contentsLike = 0;
    }

    //Contents  업데이트
    public void update (ContentsRequestDto contentsRequestDto) {
        this.userId = contentsRequestDto.getUserId();
        this.contents = contentsRequestDto.getContents();
        this.img = contentsRequestDto.getImg();
        this.insertDt = contentsRequestDto.getInsertDt();
    }

    //좋아요 업데이트
    public void updateLike(ContentsLikeDto contentsLikeDto) {
        this.contentsLike = contentsLikeDto.getContentsLike();
    }
}
