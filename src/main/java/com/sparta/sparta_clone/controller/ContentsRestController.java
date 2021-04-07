package com.sparta.sparta_clone.controller;


import com.sparta.sparta_clone.domain.Contents;
import com.sparta.sparta_clone.dto.ContentsLikeDto;
import com.sparta.sparta_clone.dto.ContentsRequestDto;
import com.sparta.sparta_clone.repository.ContentsRepository;
import com.sparta.sparta_clone.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class ContentsRestController {

    private final ContentsService contentsService;
    private final ContentsRepository contentsRepository;

    //게시글 전체 조회-최신순
    @GetMapping("/api/contents")
    public List<Contents> getContents() {
//        return contentsService.getContents();
        return contentsRepository.findAll();
    }

    //게시글 작성
    @PostMapping("/api/contents")
    public Contents creatContents(@RequestBody ContentsRequestDto contentsRequestDto) {
        return contentsService.createContents(contentsRequestDto);
    }

    //게시글 수정
    @PutMapping("/api/contents/{id}")
    public Long updateContents(@PathVariable Long id, @RequestBody ContentsRequestDto contentsRequestDto) {
        return contentsService.update(id, contentsRequestDto);
    }

    //게시글 삭제
    @DeleteMapping("/api/contents/{id}")
    public Long deleteContents(@PathVariable Long id) {
        contentsService.deleteContents(id);
        return id;
    }

    //좋아요 카운트 증가
    @GetMapping("api/like/add/{id}")
    public Long addLike(@PathVariable Long id, @RequestBody ContentsLikeDto contentsLikeDto) {
        return contentsService.addLike(id, contentsLikeDto);
    }

    //좋아요 카운트 감소
    @PutMapping("/api/like/sub/{id}")
    public Long subLike(@PathVariable Long id, @RequestBody ContentsLikeDto contentsLikeDto) {
        return contentsService.subLike(id, contentsLikeDto);
    }


}
