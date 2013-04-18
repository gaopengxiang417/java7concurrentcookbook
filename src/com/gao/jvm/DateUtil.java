package com.gao.jvm;

import java.util.Calendar;
import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-4-17
 * Time: 下午8:53
 */
public class DateUtil {

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();

        instance.set(Calendar.MINUTE, 01);

        String result = computeDateSecond(instance.getTime());
        System.out.println(result);

        instance.set(Calendar.HOUR_OF_DAY , 19);
        System.out.println(computeDateSecond(instance.getTime()));

        instance.set(Calendar.DAY_OF_MONTH , 9);
        System.out.println(computeDateSecond(instance.getTime()));

        instance.set(Calendar.MONTH, 1);
        System.out.println(computeDateSecond(instance.getTime()));

        instance.set(Calendar.YEAR, 2011);
        System.out.println(computeDateSecond(instance.getTime()));
    }

    public static String computeDateSecond(Date beforeDate) {
        Calendar before = Calendar.getInstance();
        before.setTime(beforeDate);
        long beforeLong = before.getTimeInMillis() / 1000;

        Calendar nowCalendar = Calendar.getInstance();
        long afterLong = nowCalendar.getTimeInMillis() / 1000;

        if(!before.before(nowCalendar))
            throw new IllegalArgumentException("before date should not be future time");

        long count = 0;
        int minutes = 60;
        int hour = 3600;
        int day = 24;
        int month = 30;
        int year = 12;
        if ((count = afterLong - beforeLong) < minutes) {
            return count + " seconds before";
        }
        if ((count = afterLong - beforeLong) >= minutes && count < hour) {
            return count / minutes + " minutes before";
        }
        if ((count = afterLong - beforeLong) >= hour && count < hour * day) {
            return count / hour + " hours before";
        }

        if ((count = afterLong - beforeLong) >= hour * day && count < hour * day * month) {
            return count / (hour * day)+ " days before";
        }
        if ((count = afterLong - beforeLong) >= hour * day * month && count < hour * day * month * year) {
            return count / (hour * day * month) + " months before";
        }
        return count / (hour * day * month * year) + " years before";
    }

    public static String computeDate(Date beforeDate) {
        Calendar before = Calendar.getInstance();
        before.setTime(beforeDate);
        Calendar nowCalendar = Calendar.getInstance();

        if(!before.before(nowCalendar))
            throw new IllegalArgumentException("before date should not be future time");

        int beforeYear = before.get(Calendar.YEAR);
        int beforeMonth = before.get(Calendar.MONTH);
        int beforeDay = before.get(Calendar.DAY_OF_MONTH);
        int beforeHour = before.get(Calendar.HOUR_OF_DAY);
        int beforeMinute = before.get(Calendar.MINUTE);
        int beforeSecond = before.get(Calendar.SECOND);

        int afterYear = nowCalendar.get(Calendar.YEAR);
        int afterMonth = nowCalendar.get(Calendar.MONTH);
        int afterDay = nowCalendar.get(Calendar.DAY_OF_MONTH);
        int afterHour = nowCalendar.get(Calendar.HOUR_OF_DAY);
        int afterMinute = nowCalendar.get(Calendar.MINUTE);
        int afterSecond = nowCalendar.get(Calendar.SECOND);

        int count = 0;
        if ((count = afterYear - beforeYear) > 0) {
            return  count+" year before";
        }
        if ((count = afterMonth  - beforeMonth) > 0) {
            return count + " month before";
        }

        if ((count = afterDay - beforeDay) > 0) {
            return count + " days before";
        }

        if ((count = afterHour - beforeHour) > 0) {
            return count + " hours before";
        }

        if ((count = afterMinute - beforeMinute) > 0) {
            return count + " minutes before";
        }

        if ((count = afterSecond - beforeSecond) > 0) {
            return count + " seconds before";
        }

        return " just now";

    }
}
