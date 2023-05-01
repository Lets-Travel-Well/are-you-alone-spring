package com.ssafy.rualone.domain.attraction.application;

import com.ssafy.rualone.domain.attraction.dao.AttractionMapper;
import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionServiceImpl implements AttractionService{
    private AttractionMapper attractionMapper;

    @Override
    public List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId) {
        return null;
    }
}
