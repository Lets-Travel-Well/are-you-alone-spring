package com.ssafy.rualone.domain.attraction.dao;

import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.attraction.entity.Gugun;
import com.ssafy.rualone.domain.attraction.entity.Sido;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttractionMapper {
    List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId);
    List<Sido> findAllSido();
    List<Gugun> findGugunBySido(int sidoCode);
}
