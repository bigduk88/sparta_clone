package com.sparta.sparta_clone.service;

import com.sparta.sparta_clone.domain.Contents;
import com.sparta.sparta_clone.dto.ContentsLikeDto;
import com.sparta.sparta_clone.dto.ContentsRequestDto;
import com.sparta.sparta_clone.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private final ContentsRepository contentsRepository;

    //게시글 조회 최신순
    public List<Contents> getContents() {
        return contentsRepository.findAllByOrderByCreateAtDesc();
    }

    //글 작성
    @Transactional
    public Contents createContents(ContentsRequestDto contentsRequestDto) {
        Contents contents = new Contents(contentsRequestDto);
        contentsRepository.save(contents);
        return contents;
    }

    //글 수정
    @Transactional
    public Long update(Long id, ContentsRequestDto contentsRequestDto) {
        Contents contents = contentsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        contents.update(contentsRequestDto);
        return contents.getId();
    }

    //글 삭제
    @Transactional
    public Long deleteContents(Long id) {
        contentsRepository.deleteById(id);
        return id;
    }

    //좋아요
    @Transactional
    public Long addLike(Long id, ContentsLikeDto contentsLikeDto) {
        Contents contents = contentsRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        int cur_like = contents.getContentsLike();
        int new_like = cur_like +1;
        contentsLikeDto.setContentsLike(new_like);
        contents.updateLike(contentsLikeDto);
        return contents.getId();
    }

    //좋아요 취소
    @Transactional
    public Long subLike(Long id, ContentsLikeDto contentsLikeDto) {
        Contents contents = contentsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        int cur_liked = contents.getContentsLike();
        int new_liked = cur_liked -1;
        contentsLikeDto.setContentsLike(new_liked);
        contents.updateLike(contentsLikeDto);
        return contents.getId();
    }
}
