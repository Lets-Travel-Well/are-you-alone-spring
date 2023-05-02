package com.ssafy.rualone.domain.member.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {
    private Long id;
    private String loginId;
    private String name;
    private String password;
    private String hashCode;
    private String email;
    private String domain;
    private Long footage;
}
