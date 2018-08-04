package com.lwh.timer.demo1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
    private String name;

    private Integer count = 0;

    public MyTimerTask(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if(count < 3){
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Current Time is: " + df.format(calendar.getTime()));
            System.out.println("My name is: " + name);
            count++;
        }else {
            /** 取消当前TimerTask里的任务 **/
            cancel();
            System.out.println("Task cancel");
        }

    }
}
