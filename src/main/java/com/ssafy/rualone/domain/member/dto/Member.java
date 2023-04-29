package com.ssafy.rualone.domain.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
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
