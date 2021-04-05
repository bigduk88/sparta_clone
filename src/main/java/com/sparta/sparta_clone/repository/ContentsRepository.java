package com.sparta.sparta_clone.repository;

import com.sparta.sparta_clone.domain.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {
    List<Contents> findAllByOrderByCreateAtDesc(); // 최신순
}
