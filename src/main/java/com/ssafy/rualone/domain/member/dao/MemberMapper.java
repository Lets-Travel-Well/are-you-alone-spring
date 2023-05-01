package com.ssafy.rualone.domain.member.dao;

import com.ssafy.rualone.domain.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int checkLoginId(String loginId);
    void join(Member member);
    Member findByLoginId(String loginId);
    void modify(Member member);
    void delete(String loginId);
    Member login(Member member);
}
