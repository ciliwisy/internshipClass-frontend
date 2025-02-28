package org.example.service.impl;

import org.example.entity.DateStat;
import org.example.mapper.DateStatMapper;
import org.example.service.DateStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateStatServiceImpl implements DateStatService {
    @Autowired
    private DateStatMapper dateStatMapper;

    @Override
    public List<DateStat> queryDateStatList() {
        return dateStatMapper.selectList(null);
    }
} 