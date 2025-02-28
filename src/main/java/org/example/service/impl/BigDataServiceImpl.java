package org.example.service.impl;

import org.example.entity.ChargerData;
import org.example.entity.UserBehavior;
import org.example.mapper.UserBehaviorMapper;
import org.example.mapper.UserChargerMapper;
import org.example.service.BigDataService;
import org.example.service.UserChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BigDataServiceImpl implements BigDataService {
    @Autowired
    UserBehaviorMapper userBehaviorMapper;

    @Override
    public List<UserBehavior> queryUserBehavior(){
        return userBehaviorMapper.queryUserBehavior();
    }

    @Override
    public List<UserBehavior> queryUserBehaviorByPage() {
        return userBehaviorMapper.queryUserBehaviorByPage();
    }

}

