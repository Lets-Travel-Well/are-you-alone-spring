package com.ssafy.rualone.domain.board.api;

import com.ssafy.rualone.domain.board.application.PostService;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.dto.request.PostUpdateRequest;
import com.ssafy.rualone.domain.board.dto.response.PostDetailResponse;
import com.ssafy.rualone.domain.board.dto.response.PostResponse;
import com.ssafy.rualone.domain.member.dto.response.MemberResponse;
import com.ssafy.rualone.global.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

import static com.ssafy.rualone.global.api.ApiResult.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board-management/post")
@Slf4j
public class PostApi {
    private final PostService postService;

    @PostMapping()
    public ApiResult<Void> save(PostCreateRequest postCreateRequest, HttpSession session) throws Exception {
        log.info("save");
        log.info(postCreateRequest.toString());
        // TODO : 멤버 완성 되면 넣기
        MemberResponse member = (MemberResponse)session.getAttribute("userInfo");
        Long memberID = member.getId();
        log.info(String.valueOf(memberID));
        postService.save(postCreateRequest, memberID);
        return OK(null);
    }

    @GetMapping("/{id}")
    public ApiResult<PostDetailResponse> findById(@PathVariable("id") Long id) throws Exception {
        log.info("findById call");

        return OK(new PostDetailResponse(postService.findById(id)));
    }

    @GetMapping()
    public ApiResult<List<PostResponse>> findAll() throws Exception {
        log.info("findAll");
        List<PostResponse> list = postService.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
        return OK(list);
    }

    @PutMapping()
    public ApiResult<Void> modify(@RequestBody PostUpdateRequest postUpdateRequest) throws Exception {
        log.info("modify");
        Long memberId = 0L;
        postService.updatePost(postUpdateRequest, memberId);
        return OK(null);
    }

    @DeleteMapping("/{id}")
    public ApiResult<Void> delete(@PathVariable("id") Long id) throws Exception{
        log.info("delete");
        postService.deletePost(id);
        return OK(null);
    }
}
