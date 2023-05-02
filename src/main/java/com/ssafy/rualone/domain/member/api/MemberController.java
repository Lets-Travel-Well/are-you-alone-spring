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
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/login")
    public String login(MemberLoginRequest memberLoginRequest, HttpSession session){
        log.info(memberLoginRequest.toString());
        MemberResponse loginInfo = new MemberResponse(memberService.login(memberLoginRequest));
        session.setAttribute("userInfo",loginInfo);
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
