package com.lwh.quartz.demo2;

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

        /** 获取距离当前时间3秒后的时间 **/
        date.setTime(date.getTime() + 3000);

        /** 获取距离当前时间6秒后的时间 **/
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);

        /** 创建一个Trigger实例,定义该Job立即执行,并且每隔两秒钟重复执行一次,直到永远 **/
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(date)
                .endAt(endDate)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        /** 创建Scheduler实例 **/
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        /** 绑定 **/
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
