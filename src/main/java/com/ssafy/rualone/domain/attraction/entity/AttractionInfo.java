package com.ssafy.rualone.domain.attraction.entity;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class AttractionInfo {
    private int contentId;
    private int contentTypeId;
    private String title;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String tel;
    private String firstImage;
    private String firstImage2;
    private int readCount;
    private int sidoCode;
    private int gugunCode;
    private double latitude;
    private double longitude;
    private String mlevel;
}