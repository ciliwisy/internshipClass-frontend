package org.example.service.impl;

import org.example.entity.ChargerData;
import org.example.mapper.UserChargerMapper;
import org.example.service.UserChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserChargerServiceImpl implements UserChargerService {
    @Autowired
    UserChargerMapper userChargerMapper;

    @Override
    public List<ChargerData> queryChargerTime() {

        return userChargerMapper.queryChargerTime();
    }
}


