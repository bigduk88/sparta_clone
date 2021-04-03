package com.sparta.cloningInstagram.controller;

import com.sparta.cloningInstagram.domain.CloneContents;
import com.sparta.cloningInstagram.domain.CloneContentsRequestDto;
import com.sparta.cloningInstagram.repository.CloneContentsRepository;
import com.sparta.cloningInstagram.service.CloneContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CloneContentsController {

    private final CloneContentsRepository cloneContentsRepository;
    private final CloneContentsService cloneContentsService;

    @PostMapping("/api/clonecontents")
    public CloneContents createCloneContents(@RequestBody CloneContentsRequestDto requestDto) {
        CloneContents clonecontents = new CloneContents(requestDto);
        return cloneContentsRepository.save(clonecontents);
    }

    @GetMapping("/api/clonecontents")
    public List<CloneContents> getCloneContents() {
        return cloneContentsRepository.findAllByOrderByCreatedAtDesc();
    }

    @PutMapping("/api/clonecontents/{id}")
    public Long updateCloneContents(@PathVariable Long id, @RequestBody CloneContentsRequestDto requestDto) {
        cloneContentsService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/clonecontents/{id}")
    public Long deleteCloneContents(@PathVariable Long id) {
        cloneContentsRepository.deleteById(id);
        return id;
    }

}