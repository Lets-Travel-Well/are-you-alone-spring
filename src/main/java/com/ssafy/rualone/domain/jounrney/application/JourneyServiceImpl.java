package com.ssafy.rualone.domain.jounrney.application;

import com.ssafy.rualone.domain.jounrney.dao.JourneyMapper;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathDto;
import com.ssafy.rualone.global.util.MakeMapUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class JourneyServiceImpl implements JourneyService{
    private final JourneyMapper journeyMapper;


    @Override
    public List<JourneyPlacePathDto> findShortestPath(List<JourneyPlacePathDto> journeyPlacePathDto) {
        return MakeMapUtils.makeShortestPath(journeyPlacePathDto);
    }



}
