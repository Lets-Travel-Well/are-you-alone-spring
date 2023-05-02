package com.ssafy.rualone.domain.jounrney.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JourneyPlaceCreateRequest {
    int contentId;
    int order;
    // TODO : 시간을 볼 수 있어야되기때문에 LocalDate로 바꿔야함,
    String tripDay;
    String content;
}
