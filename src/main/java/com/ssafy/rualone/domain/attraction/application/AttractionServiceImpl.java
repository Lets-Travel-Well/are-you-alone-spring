package com.ssafy.rualone.domain.attraction.application;

import com.ssafy.rualone.domain.attraction.dao.AttractionMapper;
import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.attraction.entity.Gugun;
import com.ssafy.rualone.domain.attraction.entity.Sido;
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
    public List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId) {
        return null;
    }

    @Override
    public List<Gugun> findGugunBySido(int sidoCode) {
        return null;
    }

    @Override
    public List<Sido> findSido() {
        return attractionMapper.findAllSido();
    }
}
