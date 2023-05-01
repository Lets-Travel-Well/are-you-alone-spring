package com.ssafy.rualone.domain.board.dto.response;

import com.ssafy.rualone.domain.board.entity.Post;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PostDetailResponse {
    private Long id;
    private Long memberId;
    private String subject;
    private String content;
    private int hit;

    // TODO : 커멘트 있으면 추가하야함

    public PostDetailResponse(Post post){
        this.id = post.getId();
        this.memberId = post.getMemberId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
    }
}
