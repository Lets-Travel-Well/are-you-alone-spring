package com.ssafy.rualone.domain.jounrney.application;

import com.ssafy.rualone.domain.jounrney.dto.request.JourneyCreateRequest;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathDto;

import java.util.List;

public interface JourneyService {
    List<JourneyPlacePathDto> findShortestPath(List<JourneyPlacePathDto> journeyPlacePathDto);

    void save(JourneyCreateRequest journeyCreateRequest, Long memberId);
}
