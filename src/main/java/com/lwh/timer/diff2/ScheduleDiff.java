package com.lwh.timer.diff2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleDiff {

    public static void main(String[] args) {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        System.out.println("Current time is: " + df.format(calendar.getTime()));

        Timer timer = new Timer();
        /** 第一次执行时间为6秒之前,随后每隔两秒执行一次 **/
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try{
                    /** 任务执行时间3秒 **/
                    Thread.sleep(3000);
                }catch (InterruptedException e){

                }
                /** 打印当前的计划执行时间 **/
                System.out.println("Scheduled exec time is: " + df.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000);

    }
}
