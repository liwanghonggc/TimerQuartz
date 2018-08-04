package com.lwh.quartz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static void printNowTime(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current exec time is: " + df.format(date));
    }
}
