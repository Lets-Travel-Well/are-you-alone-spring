package com.ssafy.rualone.domain.member.dto.request;

import com.ssafy.rualone.domain.member.dto.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberModifyRequest {
    private Long id;
    private String loginId;
    private String name;
    private String password;
    private String hashCode;
    private String email;
    private String domain;
    private Long footage;

    public Member toEntity(){
        return Member.builder()
                .id(this.id)
                .loginId(this.loginId)
                .password(this.password)
                .name(this.name)
                .password(this.password)
                .hashCode(this.hashCode)
                .email(this.email)
                .domain(this.domain)
                .footage(this.footage)
                .build();
    }
}
