package com.ssafy.rualone.domain.jounrney.application;

import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathDto;

import java.util.List;

public interface JourneyService {
    List<JourneyPlacePathDto> findShortestPath(List<JourneyPlacePathDto> journeyPlacePathDto);
}
