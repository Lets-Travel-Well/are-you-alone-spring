package com.ssafy.rualone.domain.board.dto.request;

import com.ssafy.rualone.domain.board.Post;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostCreateRequest {
    private String subject;
    private String content;
    // TODO : member 추가되면 추가 시켜야함
    public Post toEntity(Long memberId){
        return Post.builder()
                .memberId(memberId)
                .subject(subject)
                .content(content)
                .hit(0)
                .build();
    }
}
