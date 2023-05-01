package com.ssafy.rualone.domain.member.dto.request;

import com.ssafy.rualone.domain.member.dto.Member;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberCreateRequest {
    private String loginId;
    private String name;
    private String password;
    private String hashCode;
    private String email;
    private String domain;
    public Member toEntity(){
        return Member.builder()
                .loginId(loginId)
                .name(name)
                .password(password)
                .hashCode(hashCode)
                .email(email)
                .domain(domain)
                .build();
    }
}
