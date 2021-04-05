package com.sparta.sparta_clone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //테이블 기본키 역할하는 id

    @Column(nullable = false)
    private String user_id; //댓글 작성자

    @Column(nullable = false)
    private String contents; //댓글 내용

    @Column(nullable = false)
    private Long contentsId; //게시글 id(외래키 역)


}
