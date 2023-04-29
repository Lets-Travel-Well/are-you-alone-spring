package com.ssafy.rualone.domain.member.dao;

import com.ssafy.rualone.domain.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
@Mapper
public interface MemberMapper {
    void join(Member member);
    Optional<Member> findById(Long id);
    Member modify(Member member);
    void delete(Long id);
}
