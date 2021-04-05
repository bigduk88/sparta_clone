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
    private String user_id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int like;

    //Contents 더미 데이터 생성자
    public Contents (String user_id, String contents, String image, int like) {
        this.user_id = user_id;
        this.contents = contents;
        this.image = image;
        this.like = like;
    }

    // Contents Dto 생성자
    public Contents(ContentsRequestDto contentsRequestDto) {
        this.user_id = contentsRequestDto.getUser_id();
        this.contents = contentsRequestDto.getContents();
        this.image = contentsRequestDto.getImage();
    }

    //Contents  업데이트
    public void update (ContentsRequestDto contentsRequestDto) {
        this.user_id = contentsRequestDto.getUser_id();
        this.contents = contentsRequestDto.getContents();
        this.image = contentsRequestDto.getImage();
        this.like = contentsRequestDto.getLike();
    }

    //좋아요 업데이트
    public void updateLike(ContentsLikeDto contentsLikeDto) { this.like = contentsLikeDto.getLike();}
}
