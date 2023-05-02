package com.ssafy.rualone.domain.attraction.entity;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
public class AttractionDescription {
	private int contentId;
	private String homepage;
	private String overview;
	private String telname;

}
