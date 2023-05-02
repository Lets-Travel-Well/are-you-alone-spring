package com.ssafy.rualone.domain.attraction.application;

import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.attraction.entity.Gugun;
import com.ssafy.rualone.domain.attraction.entity.Sido;

import java.util.List;

public interface AttractionService {
    List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId);
    List<Sido> findSido();
    List<Gugun> findGugunBySido(int sidoCode);
}
