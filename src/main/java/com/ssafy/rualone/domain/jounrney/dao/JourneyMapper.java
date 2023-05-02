package com.ssafy.rualone.domain.jounrney.dao;

import com.ssafy.rualone.domain.jounrney.entity.Journey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JourneyMapper {
    void save(Journey journey);
}
