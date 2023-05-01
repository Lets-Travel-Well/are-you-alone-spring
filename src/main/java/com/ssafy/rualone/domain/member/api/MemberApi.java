package com.ssafy.rualone.domain.member.api;

import com.ssafy.rualone.domain.member.dto.Member;
import com.ssafy.rualone.domain.member.application.MemberService;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
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
        log.info("asd");
        log.info(memberCreateRequest.toString());
        Member createMember = memberService.join(memberCreateRequest);
        return new ResponseEntity<Member>(createMember, HttpStatus.OK);
    }

}
