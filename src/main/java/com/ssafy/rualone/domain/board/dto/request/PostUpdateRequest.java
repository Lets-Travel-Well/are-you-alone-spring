package com.ssafy.rualone.domain.board.dto.request;

import com.ssafy.rualone.domain.board.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PostUpdateRequest {
    private Long id;
    private String subject;
    private String content;

    public Post toEntity(Long memberId){
        return Post.builder()
                .id(id)
                .memberId(memberId)
                .subject(subject)
                .content(content)
                .build();
    }
}
