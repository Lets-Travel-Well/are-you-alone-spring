package com.ssafy.rualone.domain.board.dto.response;

import com.ssafy.rualone.domain.board.Post;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PostResponse {
    private Long id;
    private Long memberId;
    private String subject;
    private String content;
    private int hit;

    public PostResponse(Post post){
        this.id = post.getId();
        this.memberId = post.getMemberId();
        this.subject = post.getSubject();
        this.content = post.getContent();
        this.hit = post.getHit();
    }
}
