package com.ssafy.rualone.domain.attraction.dao;

import com.ssafy.rualone.domain.attraction.entity.AttractionInfo;
import com.ssafy.rualone.domain.attraction.entity.Gugun;
import com.ssafy.rualone.domain.attraction.entity.Sido;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AttractionMapper {
    Optional<AttractionInfo> findByContentId(int contentId);
    List<AttractionInfo> findAllByCriteria(String sidoCode, String gugunCode, String contentTypeId);
    List<Sido> findAllSido();
    List<Gugun> findGugunBySido(int sidoCode);
}
