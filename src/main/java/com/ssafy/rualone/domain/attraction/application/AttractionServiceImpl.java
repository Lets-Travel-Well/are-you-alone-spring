package com.ssafy.rualone.domain.attraction.application;

import com.ssafy.rualone.domain.attraction.dao.AttractionMapper;
import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.attraction.entity.Gugun;
import com.ssafy.rualone.domain.attraction.entity.Sido;
import com.ssafy.rualone.domain.board.entity.Post;
import com.ssafy.rualone.global.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttractionServiceImpl implements AttractionService{
    private final AttractionMapper attractionMapper;


    @Override
    public AttractionInfo findByContentId(int contentId) {
        return attractionMapper.findByContentId(contentId).orElseThrow(() -> new NotFoundException(Post.class, contentId));
    }

    @Override
    public List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId) {
        return attractionMapper.findAllByCriteria(sidoCode, gugunCode, contentTypeId);
    }
    @Override
    public List<Sido> findSido() {
        return attractionMapper.findAllSido();
    }
    @Override
    public List<Gugun> findGugunBySido(int sidoCode) {
        return attractionMapper.findGugunBySido(sidoCode);
    }
}
