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

    @Column
    private String userId;

    @Column
    private String userName;

    @Column
    private String contents;

    @Column
    private String img;

    @Column
    private String myImg;

    @Column
    private String insertDt;

    @Column
    private int contentsLike;

    @Column
    private Long likeCnt;

    @Column
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
        this.likeCnt = contentsRequestDto.getLikeCnt();
        this.likeId = contentsRequestDto.getLikeId();
    }

    //좋아요 업데이트
    public void updateLike(ContentsLikeDto contentsLikeDto) {
        this.contentsLike = contentsLikeDto.getContentsLike();
    }
}
