package com.ssafy.rualone.domain.jounrney.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class Journey {
    private Long id;
    private Long leaderId;
    private boolean visibility;
    private int travelersCnt;
    private LocalDateTime deadLine;
    private LocalDateTime startDay;
}
