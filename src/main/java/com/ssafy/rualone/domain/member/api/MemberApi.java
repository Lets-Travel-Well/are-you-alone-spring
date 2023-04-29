package com.ssafy.rualone.domain.member.api;

import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.application.MemberService;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user-management")
@Slf4j
public class MemberApi {
    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody MemberCreateRequest memberCreateRequest){
        Member createMember = memberService.join(memberCreateRequest);
        return new ResponseEntity<Member>(createMember, HttpStatus.OK);
    }

    @GetMapping("/user/{loginId}")
    public ResponseEntity<MemberResponse> findMemberByLoginId(@PathVariable("loginId") String loginId){
        MemberResponse loginMember = new MemberResponse(memberService.findById(loginId));
        return new ResponseEntity<MemberResponse>(loginMember,HttpStatus.OK);
    }

}
