package com.sparta.sparta_clone.domain;

import com.sparta.sparta_clone.dto.CommentRequestDto;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public Comment (CommentRequestDto commentRequestDto){
        this.contentsId = commentRequestDto.getContentsId();
        this.userId = commentRequestDto.getUserId();
        this.comment = commentRequestDto.getComment();
        this.myImg = commentRequestDto.getMyImg();
        this.commentDt = commentRequestDto.getCommentDt();
    }

    public void update_comment(CommentRequestDto commentRequestDto){
        this.contentsId = commentRequestDto.getContentsId();
        this.userId = commentRequestDto.getUserId();
        this.comment = commentRequestDto.getComment();
        this.myImg = commentRequestDto.getMyImg();
        this.commentDt = commentRequestDto.getCommentDt();
    }
}