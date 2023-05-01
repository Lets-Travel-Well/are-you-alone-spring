package com.ssafy.rualone.domain.attraction.dao;

import com.ssafy.rualone.domain.attraction.entity.Sido;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttractionMapper {
    List<Sido> findAllSido();
}
