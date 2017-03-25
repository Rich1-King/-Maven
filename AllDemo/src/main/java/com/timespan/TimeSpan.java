package com.timespan;

import java.util.Calendar;

/**
 * Created by rich1 on 10/31/16.
 */
public class TimeSpan{
    public static void main(String[] args){

        calendarTimeMonthAdd();
        calendarTimeDayAdd();

        Calendar calendarStart = Calendar.getInstance();
        calendarStart.add(Calendar.MONTH, -1);
        calendarStart.set(Calendar.DAY_OF_MONTH, 1);
        calendarStart.set(Calendar.HOUR_OF_DAY,0);
        calendarStart.set(Calendar.MINUTE, 0);
        calendarStart.set(Calendar.SECOND, 0);
        calendarStart.set(Calendar.MILLISECOND, 0);

        System.out.println(calendarStart.getTimeInMillis());

        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.add(Calendar.MONTH, 0);
        calendarEnd.set(Calendar.DAY_OF_MONTH, 0);
        calendarEnd.set(Calendar.HOUR_OF_DAY, 23);
        calendarEnd.set(Calendar.MINUTE, 59);
        calendarEnd.set(Calendar.SECOND,59);
        calendarEnd.set(Calendar.MILLISECOND, 999);

        System.out.println(calendarEnd.getTimeInMillis());

        Calendar end = Calendar.getInstance();
        end.add(Calendar.MONTH, -1);
        end.set(Calendar.DAY_OF_MONTH, 0);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND,59);
        end.set(Calendar.MILLISECOND, 999);
        System.out.println(end.getTimeInMillis());
    }

    //当开始时间是本年的一月份，月份份减一变成上一年的12月
    private static void calendarTimeMonthAdd(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1451577600000l);
        calendar.add(Calendar.MONTH, -1);
        System.out.println(calendar.getTimeInMillis());
    }

    private static void calendarTimeDayAdd(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1451577600000l);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        System.out.println(calendar.getTimeInMillis());
    }

}
