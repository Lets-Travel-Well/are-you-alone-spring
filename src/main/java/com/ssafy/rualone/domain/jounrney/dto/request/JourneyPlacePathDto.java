package com.ssafy.rualone.domain.jounrney.dto.request;

import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JourneyPlacePathDto {
    private int contentId;
    private double latitude;
    private double longitude;

    public JourneyPlacePathDto(AttractionInfo attractionInfo){
        this.contentId = attractionInfo.getContentId();
        this.latitude = attractionInfo.getLatitude();
        this.longitude = attractionInfo.getLongitude();
    }
}
