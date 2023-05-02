package com.ssafy.rualone.domain.jounrney.application;

import com.ssafy.rualone.domain.attraction.application.AttractionService;
import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.jounrney.dao.JourneyMapper;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JourneyServiceImpl implements JourneyService{
    private final JourneyMapper journeyMapper;
    @Override
    public List<AttractionInfo> findShortestPath(List<JourneyPlacePathCreateRequest> journeyPlacePathCreateRequest) {

        return null;
    }
}
