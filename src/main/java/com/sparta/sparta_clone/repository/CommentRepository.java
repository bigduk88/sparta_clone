package com.sparta.sparta_clone.repository;

import com.sparta.sparta_clone.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByContentsId(long contentsId);

}
