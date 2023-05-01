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
    public void save(PostCreateRequest postCreateRequest, Long memberID) throws Exception {
        postMapper.save(postCreateRequest.toEntity(memberID));
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
    public void updatePost(PostUpdateRequest postUpdateRequest, Long memberId) throws Exception {
        Post updatePost = postUpdateRequest.toEntity(memberId);
        log.info(updatePost.toString());
        postMapper.updatePost(updatePost);
    }

    @Override
    public void deletePost(Long postId) throws Exception {
        postMapper.deletePost(postId);
    }
}
