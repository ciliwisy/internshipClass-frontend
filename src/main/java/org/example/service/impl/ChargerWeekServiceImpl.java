package org.example.service.impl;

import org.example.entity.ChargerWeekTime;
import org.example.mapper.ChargerWeekMapper;
import org.example.service.ChargerWeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargerWeekServiceImpl implements ChargerWeekService {
    @Autowired
    org.example.mapper.ChargerWeekMapper ChargerWeekMapper;

    @Override
    public List<ChargerWeekTime> queryChargerWeekTime() {
        return ChargerWeekMapper.queryChargerWeek();
    }
}
