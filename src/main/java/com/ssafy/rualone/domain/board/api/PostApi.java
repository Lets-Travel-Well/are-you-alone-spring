package com.ssafy.rualone.domain.board.api;

import com.ssafy.rualone.domain.board.application.PostService;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.dto.request.PostUpdateRequest;
import com.ssafy.rualone.domain.board.dto.response.PostDetailResponse;
import com.ssafy.rualone.domain.board.dto.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board-management/post")
@Slf4j
public class PostApi {
    private final PostService postService;

    @PostMapping()
    public ResponseEntity<PostResponse> save(@RequestBody PostCreateRequest postCreateRequest) throws Exception {
        log.info("save");
        log.info(postCreateRequest.toString());
        // TODO : 멤버 완성 되면 넣기
        Long memberID = 0L;
        PostResponse postResponse = new PostResponse(postService.save(postCreateRequest, memberID));
        log.info(postResponse.toString());
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResponse> findById(@PathVariable("id") Long id) throws Exception {
        log.info("findById call");

        return new ResponseEntity<>(new PostDetailResponse(postService.findById(id)), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PostResponse>> findAll() throws Exception {
        log.info("findAll");
        List<PostResponse> list = postService.findAll().stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<PostResponse> modify(PostUpdateRequest postUpdateRequest){
        log.info("modify");
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        log.info("delete");

        return null;
    }
}
