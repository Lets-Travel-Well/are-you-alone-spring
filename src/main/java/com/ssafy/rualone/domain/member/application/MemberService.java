package com.ssafy.rualone.domain.member.application;

import com.ssafy.rualone.domain.member.entity.Member;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberLoginRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberModifyRequest;

public interface MemberService {
    int checkLoginId(String loginId);
    void join(MemberCreateRequest memberCreateRequest);
    Member findById(String loginId);
    void modify(MemberModifyRequest memberModifyRequest);
    void delete(String loginId);

    Member login(MemberLoginRequest memberLoginRequest);
}
