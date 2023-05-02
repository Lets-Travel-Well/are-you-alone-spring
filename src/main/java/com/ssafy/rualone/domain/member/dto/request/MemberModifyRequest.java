package com.ssafy.rualone.domain.member.dto.request;

import com.ssafy.rualone.domain.member.entity.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberModifyRequest {
    private String loginId;
    private String email;
    private String domain;

    public Member toEntity(){
        return Member.builder()
                .loginId(this.loginId)
                .email(this.email)
                .domain(this.domain)
                .build();
    }
}
