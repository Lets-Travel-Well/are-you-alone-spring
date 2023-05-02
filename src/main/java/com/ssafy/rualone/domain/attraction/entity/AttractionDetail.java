package com.ssafy.rualone.domain.attraction.entity;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class AttractionDetail {
	private int contentId;
	private String cat1;
	private String cat2;
	private String cat3;
	private String createdTime;
	private String modifiedTime;
	private String booktour;
}
