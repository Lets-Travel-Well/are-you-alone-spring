package com.ssafy.rualone.domain.member.dao;

import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
@Mapper
public interface MemberMapper {
    void join(Member member);
    Member findByLoginId(String loginId);
    void modify(Member member);
    void delete(String loginId);
}
