package org.example.controller;

import org.example.entity.*;
import org.example.mapper.DateStatMapper;
import org.example.service.BigDataService;
import org.example.service.ChargerWeekService;
import org.example.service.DateStatService;
import org.example.service.UserChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
public class BigDataController {
    @Autowired
    BigDataService bigDataService;
    @GetMapping("/test")
    public String test(){
        return "HELLO";
    }
    @GetMapping("/usertest")
    public List<UserBehavior> queryUserBehavior(){
        // 可以添加参数来指定需要返回的字段
        return bigDataService.queryUserBehavior();
    }
    @GetMapping("/userbehavior")
    public List<UserBehavior> queryUserBehaviorByPage(){
        // 可以添加参数来指定需要返回的字段
        return bigDataService.queryUserBehaviorByPage();
    }

    @Autowired
    UserChargerService UserChargerService;
    @GetMapping("/chargerTime")
    public List<ChargerData> queryChargerTime(){
        // 可以添加参数来指定需要返回的字段
        return UserChargerService.queryChargerTime();
    }
    @Autowired
    ChargerWeekService chargerWeekService;
    @GetMapping("/chargerWeekTime")
    public List<ChargerWeekTime> queryChargerWeekTime(){
        // 可以添加参数来指定需要返回的字段
        return chargerWeekService.queryChargerWeekTime();
    }

    @Autowired
    private DateStatService dateStatService;

    @GetMapping("/userbehaviordate")
    public DateStatVo queryDateStatList() {
        List<DateStat> entityList = dateStatService.queryDateStatList();
        List<String> typeList = Arrays.asList("pv","fav","cart","buy");
        // 组装⽇期列表，第⼀个列表⽤于返回前端作为X轴，第⼆个列表⽤于后续循环处理数据
        List<String> dateStrList = new ArrayList<>(); Set<Date> uniqueDates = new HashSet<>();
        // 填充两个列表
        for (DateStat item: entityList) {
            if (!uniqueDates.contains(item.getDate())){ uniqueDates.add(item.getDate());
                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); String dateStr = sdf.format(item.getDate()); dateStrList.add(dateStr);
            }
        }
        // 返回给前端的数据对象
        DateStatVo dateStatVo = new DateStatVo(); dateStatVo.setDateList(dateStrList); dateStatVo.setEventCnt(new ArrayList<>());
        // 按顺序组装每个⾏为对应的每⽇⾏为信息
        for (String type: typeList) {
            List<Long> cntList = new ArrayList<>();
            for (Date itemDate: uniqueDates) {
                String cnt = entityList.stream().filter(v -> v.getDate(). equals(itemDate) && v.getEventType().equals(type)) .map(DateStat::getCnt).findFirst().orElse("0"); cntList.add(Long.valueOf(cnt));
            } dateStatVo.getEventCnt().add(cntList);
        }
        return dateStatVo;
    }
}
