package com.ssafy.rualone.domain.member.dto.request;

import com.ssafy.rualone.domain.member.dto.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberUpdateRequest {
    private Long id;
    private String password;
    private String hashCode;
    private String email;
    private String domain;
    public Member toEntity(){
        return Member.builder()
                .password(password)
                .hashCode(hashCode)
                .email(email)
                .domain(domain)
                .build();
    }

}
