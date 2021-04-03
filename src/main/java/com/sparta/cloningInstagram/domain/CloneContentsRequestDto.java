package com.sparta.cloningInstagram.domain;

import lombok.Getter;

@Getter
public class CloneContentsRequestDto {
    private String contents;
    private String user_id;
    private Long insert_dt;
    private String like_users;
    private Long like_cnt;
    private String like_ids;
    private String image_url;
}