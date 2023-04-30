package com.ssafy.rualone.domain.member.application;

import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberModifyRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberUpdateRequest;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;

import java.util.Optional;

public interface MemberService {
    void join(MemberCreateRequest memberCreateRequest);
    Member findById(String loginId);
    void modify(MemberModifyRequest memberModifyRequest);
    void delete(String loginId);
}
