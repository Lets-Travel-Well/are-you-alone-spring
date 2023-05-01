package com.ssafy.rualone.domain.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Post {
    private Long id;
    private Long memberId;
    private String subject;
    private String content;
    private int hit;
}
