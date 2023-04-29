package com.ssafy.rualone.domain.board.application;

import com.ssafy.rualone.domain.board.Post;
import com.ssafy.rualone.domain.board.dao.PostMapper;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.dto.request.PostUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostMapper postMapper;
    @Override
    public Post save(PostCreateRequest postCreateRequest, Long memberID) throws Exception {
        Post newPost = postCreateRequest.toEntity(memberID);
        postMapper.save(newPost);
        return newPost;
    }

    @Override
    public Post findById(Long id) throws Exception {
        return postMapper.findById(id);
    }

    @Override
    public List<Post> findAll() throws Exception {
        return postMapper.findAll();
    }

    @Override
    public Post updatePost(PostUpdateRequest postUpdateRequest) throws Exception {
        return null;
    }

    @Override
    public void deletePost(Long id) throws Exception {

    }
}
