package org.example.service;

import org.example.entity.ChargerWeekTime;
import org.example.entity.UserBehavior;
import org.example.mapper.UserBehaviorMapper;

import java.util.List;

public interface BigDataService {
    List<UserBehavior> queryUserBehavior();

    List<UserBehavior> queryUserBehaviorByPage();
}


