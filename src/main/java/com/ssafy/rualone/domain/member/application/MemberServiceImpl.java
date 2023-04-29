package com.ssafy.rualone.domain.member.application;

import com.ssafy.rualone.domain.member.dao.MemberMapper;
import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
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
}
