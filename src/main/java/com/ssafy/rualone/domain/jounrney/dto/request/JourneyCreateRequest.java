package com.ssafy.rualone.domain.jounrney.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class JourneyCreateRequest {
    private String deadLine;
    private String startDay;
    private List<JourneyPlaceCreateRequest> journeyPlaces = new ArrayList<>();
}
