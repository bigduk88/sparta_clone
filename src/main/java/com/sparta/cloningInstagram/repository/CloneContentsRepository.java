package com.sparta.cloningInstagram.repository;

import com.sparta.cloningInstagram.domain.CloneContents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloneContentsRepository extends JpaRepository<CloneContents, Long> {
    List<CloneContents> findAllByOrderByCreatedAtDesc();
}
