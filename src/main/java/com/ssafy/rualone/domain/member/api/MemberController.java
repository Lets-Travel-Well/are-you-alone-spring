package com.ssafy.rualone.domain.member.api;

import com.ssafy.rualone.domain.member.application.MemberService;
import com.ssafy.rualone.domain.member.dto.request.MemberLoginRequest;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
//Todo : MemberController request 명칭
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public String login(MemberLoginRequest memberLoginRequest, HttpSession session){
        MemberResponse loginInfo = new MemberResponse(memberService.login(memberLoginRequest));
        session.setAttribute("userInfo",loginInfo);
        log.info(loginInfo.toString());
        return "/";
    }

}
