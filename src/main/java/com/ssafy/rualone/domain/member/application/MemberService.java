package com.ssafy.rualone.domain.member.application;

import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;

public interface MemberService {
    Member join(MemberCreateRequest memberCreateRequest);
//    Optional<Member> findById(Long id);
//    Member modify(Member member);
//    void delete(Long id);
}
