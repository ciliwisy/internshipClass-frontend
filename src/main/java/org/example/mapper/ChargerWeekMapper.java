package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.ChargerWeekTime;

import java.util.List;

@Mapper
public interface ChargerWeekMapper {
    @Select("select * from chargerDayTime")
    List<ChargerWeekTime> queryChargerWeek();
}
