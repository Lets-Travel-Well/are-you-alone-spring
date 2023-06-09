package com.ssafy.rualone.domain.member.application;

import com.ssafy.rualone.domain.member.dao.MemberMapper;
import com.ssafy.rualone.domain.member.entity.Member;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberLoginRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberModifyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public int checkLoginId(String loginId) {
        int cnt = memberMapper.checkLoginId(loginId);
        return cnt;
    }

    @Override
    public void join(MemberCreateRequest memberCreateRequest) {
        Member joinMember = memberCreateRequest.toEntity();
        memberMapper.join(joinMember);
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

    @Override
    public void delete(String loginId) {
        memberMapper.delete(loginId);
    }

    @Override
    public Member login(MemberLoginRequest memberLoginRequest) {
        Member loginMember = memberLoginRequest.ToEntity();
        return memberMapper.login(loginMember);
    }
}
