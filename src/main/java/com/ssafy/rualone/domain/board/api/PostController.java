package com.ssafy.rualone.domain.board.api;

import com.ssafy.rualone.domain.board.application.PostService;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.entity.Post;
import com.ssafy.rualone.domain.member.application.MemberService;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/post/write")
    public String mvWrite(){
        return "post/write";
    }

    @PostMapping("/post/write")
    public String write(PostCreateRequest postCreateRequest, HttpSession session) throws Exception {
        MemberResponse response = (MemberResponse)session.getAttribute("userInfo");
        log.info(response.toString());
        postService.save(postCreateRequest,response.getId());
        return "redirect:/post";
    }

    @GetMapping("/post/{postId}")
    public String mvWrite(Long postId){
        return "post/write";
    }
}
