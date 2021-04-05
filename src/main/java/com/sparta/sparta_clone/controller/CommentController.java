package com.sparta.sparta_clone.controller;

import com.sparta.sparta_clone.domain.Comment;
import com.sparta.sparta_clone.dto.CommentRequestDto;
import com.sparta.sparta_clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    //댓글 조회
    @GetMapping("/api/comments")
    public List<Comment> getComment() {
        return commentService.getComment();
    }

    //게시글 아이디에 해당하는 댓글 조회
    @GetMapping("/api/comments/{contentsId}")
    public List<Comment> getCommentForContentsId(@PathVariable Long contentsId){
        return commentService.getCommentForContentsId(contentsId);
    }

    //댓글 수정
    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentService.createComment(commentRequestDto);
    }

    //댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}
