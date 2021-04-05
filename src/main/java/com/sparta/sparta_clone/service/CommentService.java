package com.sparta.sparta_clone.service;

import com.sparta.sparta_clone.domain.Comment;
import com.sparta.sparta_clone.dto.CommentRequestDto;
import com.sparta.sparta_clone.repository.CommentRepository;
import com.sparta.sparta_clone.util.CommentSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 조회
    @Transactional
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    @Transactional
    public List<Comment> getCommentForContentsId(Long contentsId) {
        return commentRepository.findAll(CommentSpecs.withContents_id(contentsId));
    }

    //댓글 작성
    @Transactional
    public Comment createComment(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(commentRequestDto);
        commentRepository.save(comment);
        return comment;
    }

    //댓글 수정
    @Transactional
    public Long updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
        return comment.getId();
    }

    //댓글 삭제
    @Transactional
    public Long deleteComment(Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
