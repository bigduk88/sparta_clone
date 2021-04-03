package com.sparta.cloningInstagram.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class CloneContents extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long post_id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String user_id;

    @Column(nullable = false)
    private Long insert_dt;

    @Column(nullable = false)
    private String like_users;

    @Column(nullable = false)
    private Long like_cnt;

    @Column(nullable = false)
    private String like_ids;

    @Column(nullable = false)
    private String image_url;

    public CloneContents(String contents, String user_id, Long insert_dt, String like_users, Long like_cnt, String like_ids, String image_url) {
        this.contents = contents;
        this.user_id = user_id;
        this.insert_dt = insert_dt;
        this.like_users = like_users;
        this.like_cnt = like_cnt;
        this.like_ids = like_ids;
        this.image_url = image_url;
    }

    public CloneContents(CloneContentsRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.user_id = requestDto.getUser_id();
        this.insert_dt = requestDto.getInsert_dt();
        this.like_users = requestDto.getLike_users();
        this.like_cnt = requestDto.getLike_cnt();
        this.like_ids = requestDto.getLike_ids();
        this.image_url = requestDto.getImage_url();
    }

    public void update(CloneContentsRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.user_id = requestDto.getUser_id();
        this.insert_dt = requestDto.getInsert_dt();
        this.like_users = requestDto.getLike_users();
        this.like_cnt = requestDto.getLike_cnt();
        this.like_ids = requestDto.getLike_ids();
        this.image_url = requestDto.getImage_url();
    }
}
