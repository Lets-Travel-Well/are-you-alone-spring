package com.ssafy.rualone.domain.board.dao;

import com.ssafy.rualone.domain.board.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    void save(Post post) throws Exception;
    Optional<Post> findById(Long id) throws Exception;
    List<Post> findAll() throws Exception;
    void updatePost(Post post) throws Exception;
    void deletePost(Long id) throws Exception;
}
