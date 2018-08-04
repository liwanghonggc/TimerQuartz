package com.lwh.quartz.simpletrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        /** 打印当前时间 **/
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current exec time is: " + df.format(date));

        /** 创建一个JobDetail实例,将该实例与HelloJob Class绑定 **/
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        /** 获取距离当前时间4秒之后的时间 **/
        date.setTime(date.getTime() + 4000);

        /** 距离当前时间4秒钟之后首次执行任务,之后每隔两秒钟执行一次,重复4次 **/
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(4))
                .build();

        /** 创建Scheduler实例 **/
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        /** 绑定 **/
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
