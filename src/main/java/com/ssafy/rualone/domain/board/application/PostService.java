package com.ssafy.rualone.domain.board.application;

import com.ssafy.rualone.domain.board.Post;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.dto.request.PostUpdateRequest;

import java.util.List;

public interface PostService {
    void save(PostCreateRequest postCreateRequest, Long memberId) throws Exception;
    Post findById(Long id) throws Exception;
    List<Post> findAll() throws Exception;
    void updatePost(PostUpdateRequest postUpdateRequest, Long memberId) throws Exception;
    void deletePost(Long id) throws Exception;
}
