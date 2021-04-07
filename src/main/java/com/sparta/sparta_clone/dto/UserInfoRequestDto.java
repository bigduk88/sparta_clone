package com.sparta.sparta_clone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoRequestDto {
    private Long id;
    private String email;
    private String userName;
    private String myImg;
}
