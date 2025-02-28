package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.ChargerWeekTime;
import org.example.entity.UserBehavior;

import java.util.List;

@Mapper
public interface UserBehaviorMapper {
    @Select("select * from test")
    List<UserBehavior> queryUserBehavior();

    @Select("select * from user_behavior")
    List<UserBehavior> queryUserBehaviorByPage();
}

