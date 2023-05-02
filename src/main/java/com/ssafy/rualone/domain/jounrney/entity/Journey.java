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
    private String subject;
    private String content;
    private boolean visibility;
    private int travelersCnt;
    private String deadLine;
    private String startDay;
}
