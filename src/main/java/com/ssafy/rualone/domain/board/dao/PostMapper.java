package com.ssafy.rualone.domain.board.dao;

import com.ssafy.rualone.domain.board.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void save(Post post) throws Exception;
    Post findById(Long id) throws Exception;
    List<Post> findAll() throws Exception;
//    Post updatePost(Post post) throws Exception;
//    void deletePost(Long id) throws Exception;
}
