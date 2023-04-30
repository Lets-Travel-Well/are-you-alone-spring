package com.ssafy.rualone.domain.member.application;

import com.ssafy.rualone.domain.member.dao.MemberMapper;
import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberModifyRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberUpdateRequest;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService{

    private final MemberMapper memberMapper;

    @Override
    public Member join(MemberCreateRequest memberCreateRequest) {
        Member joinMember = memberCreateRequest.toEntity();
        memberMapper.join(joinMember);
        return joinMember;
    }

    @Override
    public Member findById(String loginId) {
        Member loginMember = memberMapper.findByLoginId(loginId);
        return loginMember;
    }

    @Override
    public void modify(MemberModifyRequest memberModifyRequest) {
        Member modifyMember = memberModifyRequest.toEntity();
        memberMapper.modify(modifyMember);
    }
}
