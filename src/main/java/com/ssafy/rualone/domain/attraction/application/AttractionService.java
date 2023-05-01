package com.ssafy.rualone.domain.attraction.application;

import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;

import java.util.List;

public interface AttractionService {
    List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId);
}
