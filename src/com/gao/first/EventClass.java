package com.gao.first;

import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午2:08
 */
public class EventClass {
    /**
     * 创建时间
     */
    private Date date;

    /**
     * 名称
     */
    private String name;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return date + ":"+name;
    }
}
