package org.example.entity;

import java.util.List;

public class DateStatVo {
    // 日期列表，用于前端X轴展示
    private List<String> dateList;
    
    // 事件计数列表，包含了不同事件类型的每日统计数据
    private List<List<Long>> eventCnt;

    // 构造函数
    public DateStatVo() {
    }

    // getter 和 setter 方法
    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public List<List<Long>> getEventCnt() {
        return eventCnt;
    }

    public void setEventCnt(List<List<Long>> eventCnt) {
        this.eventCnt = eventCnt;
    }

}
