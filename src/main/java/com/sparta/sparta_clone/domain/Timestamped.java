package com.sparta.sparta_clone.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    //작성한 날짜
    @CreatedDate
    private LocalDateTime createAt;

    //수정한 날짜
    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
