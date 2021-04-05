package com.sparta.sparta_clone.domain;

import com.sparta.sparta_clone.dto.CommentRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //테이블 기본키 역할하는 id

    @Column(nullable = false)
    private String userId; //댓글 작성자

    @Column(nullable = false)
    private String comment; //댓글 내용

    @Column(nullable = false)
    private Long contentsId; //게시글 id(외래키 역)

    @Column(nullable = false)
    private String commentDt; //댓글 작성 시간

    //comment DTO 생성자
    public Comment(CommentRequestDto commentRequestDto) {
        this.userId = commentRequestDto.getUserId();
        this.comment = commentRequestDto.getComment();
        this.contentsId = commentRequestDto.getContentsId();
        this.commentDt = commentRequestDto.getCommentDT();
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
    }

}
