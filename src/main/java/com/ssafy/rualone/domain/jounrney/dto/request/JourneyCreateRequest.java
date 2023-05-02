package com.ssafy.rualone.domain.jounrney.dto.request;

import com.ssafy.rualone.domain.jounrney.entity.Journey;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class JourneyCreateRequest {
    private String subject;
    private String content;
    private boolean visibility;
    private int travelersCnt;
    private String deadLine;
    private String startDay;
    private List<JourneyPlaceCreateRequest> journeyPlaces = new ArrayList<>();
    public Journey toEntity(Long memberId){
        return Journey.builder()
                .leaderId(memberId)
                .subject(subject)
                .content(content)
                .visibility(visibility)
                .travelersCnt(travelersCnt)
                .deadLine(deadLine)
                .startDay(startDay)
                .build();
    }
}
