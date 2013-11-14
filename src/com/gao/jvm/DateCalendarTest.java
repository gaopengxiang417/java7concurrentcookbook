package com.gao.jvm;

import java.util.Calendar;
import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午2:11
 */
public class DateCalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH , -1);
        calendar.set(Calendar.HOUR_OF_DAY , 0);
        calendar.set(Calendar.MINUTE , 0);
        calendar.set(Calendar.SECOND , 0);

        Date start = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY ,23);
        calendar.set(Calendar.MINUTE , 59);
        calendar.set(Calendar.SECOND , 59);

        Date end = calendar.getTime();

        System.out.println(start);
        System.out.println(end);
    }
}
