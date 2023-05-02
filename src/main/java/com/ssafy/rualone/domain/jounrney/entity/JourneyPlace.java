package com.ssafy.rualone.domain.jounrney.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class JourneyPlace {
    private Long id;
    private int order;
}
