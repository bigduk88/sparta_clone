package com.sparta.sparta_clone.controller;

import com.sparta.sparta_clone.dto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    //댓글 조회
    @GetMapping("/api/comments/{contentsId}")
    public List<Comment> getComments() { return commentService.getComments();}

    //댓글 수정
    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) { return commentService.deleteComment(id);}

}
