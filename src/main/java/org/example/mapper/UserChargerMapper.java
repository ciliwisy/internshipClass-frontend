package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.ChargerData;


import java.util.List;

@Mapper
public interface UserChargerMapper {
    @Select("select * from chargerTime")
    List<ChargerData> queryChargerTime();
}
