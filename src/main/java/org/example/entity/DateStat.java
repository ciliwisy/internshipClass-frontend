package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.util.Date;

@TableName("date_stat")  // 对应数据库表名
public class DateStat {
    @TableField("date")
    private Date date;

    @TableField("event_type")
    private String eventType;

    @TableField("cnt")
    private String cnt;

    // 构造函数
    public DateStat() {
    }

    // getter 和 setter 方法
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

}
