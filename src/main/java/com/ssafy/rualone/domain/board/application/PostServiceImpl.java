package com.ssafy.rualone.domain.board.application;

import com.ssafy.rualone.domain.board.Post;
import com.ssafy.rualone.domain.board.dao.PostMapper;
import com.ssafy.rualone.domain.board.dto.request.PostCreateRequest;
import com.ssafy.rualone.domain.board.dto.request.PostUpdateRequest;
import com.ssafy.rualone.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return isExist(id);
    }

    @Override
    public List<Post> findAll() throws Exception {
        return postMapper.findAll();
    }

    @Override
    public void updatePost(PostUpdateRequest postUpdateRequest, Long memberId) throws Exception {
        isExist(postUpdateRequest.getId());
        Post updatePost = postUpdateRequest.toEntity(memberId);
        postMapper.updatePost(updatePost);
    }

    @Override
    public void deletePost(Long postId) throws Exception {
        isExist(postId);
        postMapper.deletePost(postId);
    }

    private Post isExist(Long id) throws Exception {
        return postMapper.findById(id).orElseThrow(() -> new NotFoundException(Post.class, id));

    }
}
