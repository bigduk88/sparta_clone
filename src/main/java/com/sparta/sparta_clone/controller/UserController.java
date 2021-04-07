package com.sparta.sparta_clone.controller;

import com.sparta.sparta_clone.domain.User;
import com.sparta.sparta_clone.repository.UserRepository;
import com.sparta.sparta_clone.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 회원가입
    @PostMapping("/api/signups")
    public Long signup(@RequestBody Map<String, String> user) {
            return userRepository.save(User.builder()
                    .email(user.get("email"))
                    .userName(user.get("userName"))
                    .password(passwordEncoder.encode(user.get("password")))
                    .myImg(user.get("myImg"))
                    .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                    .build()).getId();
        }

    // 로그인
    @PostMapping("/api/logins")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getEmail(), member.getUsername(), member.getMyImg(), member.getRoles());
    }

    @GetMapping("/api/users")
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
