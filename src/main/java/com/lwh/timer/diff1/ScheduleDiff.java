package com.lwh.timer.diff1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleDiff {

    public static void main(String[] args) {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        System.out.println("Current time is: " + df.format(calendar.getTime()));


        /** 设置成六秒之前的时间,若当前时间为2018-12-28 00:00:06,那么设置之后的时间变成2018-12-28 00:00:00 **/
        calendar.add(Calendar.SECOND, -6);

        Timer timer = new Timer();
        /** 第一次执行时间为6秒之前,随后每隔两秒执行一次 **/
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                /** 打印当前的计划执行时间 **/
                System.out.println("Scheduled exec time is: " + df.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);

    }
}
