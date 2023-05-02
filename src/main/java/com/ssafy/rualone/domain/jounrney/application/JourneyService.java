package com.ssafy.rualone.domain.jounrney.application;

import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.jounrney.dto.request.JourneyPlacePathCreateRequest;

import java.util.List;

public interface JourneyService {
    List<AttractionInfo> findShortestPath(List<JourneyPlacePathCreateRequest> journeyPlacePathCreateRequest);
}
