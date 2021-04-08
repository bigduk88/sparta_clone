package com.sparta.sparta_clone.controller;

import com.sparta.sparta_clone.domain.Comment;
import com.sparta.sparta_clone.dto.CommentRequestDto;
import com.sparta.sparta_clone.repository.CommentRepository;
import com.sparta.sparta_clone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/api/comments/{contentsId}")
    public List<Comment> getComment(@PathVariable Long contentsId){
        return commentRepository.findByContentsId(contentsId);
    }

<<<<<<< HEAD
=======
    //댓글 작성
>>>>>>> refs/remotes/origin/master
    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto){
        Comment comment = new Comment(commentRequestDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.update_comment(id, commentRequestDto);
    }

<<<<<<< HEAD
=======
    //댓글 수정
    @PutMapping("/api/comments/{id}")
    public Long updaeComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(id, commentRequestDto);
    }

    //댓글 삭제
>>>>>>> refs/remotes/origin/master
    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
