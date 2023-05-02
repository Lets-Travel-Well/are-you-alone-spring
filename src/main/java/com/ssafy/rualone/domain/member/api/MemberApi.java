package com.ssafy.rualone.domain.member.api;

import com.ssafy.rualone.domain.member.application.MemberService;
import com.ssafy.rualone.domain.member.dto.request.MemberCreateRequest;
import com.ssafy.rualone.domain.member.dto.request.MemberModifyRequest;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-management")
@Slf4j
public class MemberApi {
    private final MemberService memberService;

    @GetMapping("/check/{loginId}")
    public ResponseEntity<Boolean> checkLoginId(@PathVariable("loginId") String loginId){
        Boolean result = memberService.checkLoginId(loginId)==1;
        return new ResponseEntity<Boolean>(result, HttpStatus.OK);
    }
    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody MemberCreateRequest memberCreateRequest){
        log.info(memberCreateRequest.toString());
        memberService.join(memberCreateRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/user/{loginId}")
    public ResponseEntity<MemberResponse> findMemberByLoginId(@PathVariable("loginId") String loginId){
        MemberResponse loginMember = new MemberResponse(memberService.findById(loginId));
        return new ResponseEntity<MemberResponse>(loginMember,HttpStatus.OK);
    }
    @PutMapping("/modify")
    public ResponseEntity<Void> modify(@RequestBody MemberModifyRequest memberModifyRequest){
        log.info(memberModifyRequest.toString());
        memberService.modify(memberModifyRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/user/{loginId}")
    public ResponseEntity<Void> delete(@PathVariable("loginId")String loginId){
        memberService.delete(loginId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
