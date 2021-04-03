package com.sparta.cloningInstagram.service;

import com.sparta.cloningInstagram.domain.CloneContents;
import com.sparta.cloningInstagram.domain.CloneContentsRequestDto;
import com.sparta.cloningInstagram.repository.CloneContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CloneContentsService {

    private final CloneContentsRepository cloneRepository;

    @Transactional
    public Long update(Long id, CloneContentsRequestDto requestDto) {
        CloneContents cloneContents = cloneRepository.findById(post_id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        cloneContents.update(requestDto);
        return cloneContents.getPost_id();
    }
}