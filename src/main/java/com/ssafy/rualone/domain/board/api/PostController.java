package com.ssafy.rualone.domain.board.api;

import com.ssafy.rualone.domain.board.application.PostService;
import com.ssafy.rualone.domain.board.entity.Post;
import com.ssafy.rualone.domain.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @GetMapping("/post")
    public String List(HttpSession session) throws Exception {
        List<Post> postList = postService.findAll();
        session.setAttribute("postList",postList);
        return "post/list";
    }
}
