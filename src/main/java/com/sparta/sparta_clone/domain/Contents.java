package com.sparta.sparta_clone.domain;

import com.sparta.sparta_clone.dto.ContentsLikeDto;
import com.sparta.sparta_clone.dto.ContentsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String userName;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String myImg;

    @Column(nullable = false)
    private String insertDt;

    @Column(nullable = false)
    private int contentsLike;

    @Column(nullable = false)
    private Long likeCnt;

    @Column(nullable = false)
    @ElementCollection
    private List<String> likeId = new ArrayList<>();

    // Contents Dto 생성자
    public Contents(ContentsRequestDto contentsRequestDto) {
        this.userId = contentsRequestDto.getUserId();
        this.userName = contentsRequestDto.getUserName();
        this.contents = contentsRequestDto.getContents();
        this.img = contentsRequestDto.getImg();
        this.myImg = contentsRequestDto.getMyImg();
        this.insertDt = contentsRequestDto.getInsertDt();
        this.contentsLike = 0;

        this.likeCnt = contentsRequestDto.getLikeCnt();
        this.likeId = contentsRequestDto.getLikeId();
    }

    //Contents  업데이트
    public void update (ContentsRequestDto contentsRequestDto) {
        this.contents = contentsRequestDto.getContents();
        this.img = contentsRequestDto.getImg();
    }

    //좋아요 업데이트
    public void updateLike(ContentsLikeDto contentsLikeDto) {
        this.contentsLike = contentsLikeDto.getContentsLike();
    }
}
