package com.sparta.sparta_clone.domain;

import com.sparta.sparta_clone.dto.CommentRequestDto;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 댓글 entity를 생성함. 댓글 고유 Id 자동 생성되며 그 외에 댓글이 쓰일 contentsId, 댓글 내용, 프로필 이미지 주소, 작성일자 column을 생성
// Timestamped가 있으므로 마지막 commentDt는 필요 없음.
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long contentsId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String myImg;

    @Column(nullable = false)
    private String commentDt;

    //commentRequestDto에 하기 정보를 담아 Service로 옮기거나 받아온다.
    public Comment (CommentRequestDto commentRequestDto){
        this.contentsId = commentRequestDto.getContentsId();
        this.userId = commentRequestDto.getUserId();
        this.comment = commentRequestDto.getComment();
        this.myImg = commentRequestDto.getMyImg();
        this.commentDt = commentRequestDto.getCommentDt();
    }
    //commentRequestDto에 하기 정보를 담아 Service로 옮기거나 받아온다.
    public void update_comment(CommentRequestDto commentRequestDto){
        this.contentsId = commentRequestDto.getContentsId();
        this.userId = commentRequestDto.getUserId();
        this.comment = commentRequestDto.getComment();
        this.myImg = commentRequestDto.getMyImg();
        this.commentDt = commentRequestDto.getCommentDt();
    }
}