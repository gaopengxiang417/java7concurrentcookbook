package com.gao.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-9-11
 * Time: 下午4:56
 */
public class CalendarTest {
    public static void main(String[] args) throws ParseException, IOException, InterruptedException {

        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));

        calendar1.set(Calendar.MONTH, 10);
        System.out.println(calendar1.getTime());
        System.out.println(calendar1.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse("20130731");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println(calendar.getTime());

        calendar.add(Calendar.MONTH , -1);
        System.out.println(calendar.getTime());


        Date date1 = dateFormat.parse("20130715");
        calendar.setTime(date1);

        System.out.println(calendar.getTime());

        calendar.add(Calendar.MONTH , -1);
        System.out.println(calendar.getTime());

        calendar.setTime( dateFormat.parse("20130911"));
        calendar.add(Calendar.DAY_OF_YEAR , -7);
        System.out.println(calendar.getTime());


        System.out.println("********华丽的分割线**************");

        calendar.setTime(dateFormat.parse("20130908"));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        System.out.println(calendar.getTime());

        Runtime runtime = Runtime.getRuntime();
        String[] strings = {"/bin/sh","-c","ls -al"};
        Process process = runtime.exec(strings);

        process.waitFor();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }


    }
}
