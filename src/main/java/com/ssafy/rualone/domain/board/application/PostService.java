package com.ssafy.rualone.domain.board.application;

import com.ssafy.rualone.domain.board.Post;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.dto.request.PostUpdateRequest;

import java.util.List;

public interface PostService {
    Post save(PostCreateRequest postCreateRequest, Long id) throws Exception;
    Post findById(Long id) throws Exception;
    List<Post> findAll() throws Exception;
    Post updatePost(PostUpdateRequest postUpdateRequest) throws Exception;
    void deletePost(Long id) throws Exception;
}
