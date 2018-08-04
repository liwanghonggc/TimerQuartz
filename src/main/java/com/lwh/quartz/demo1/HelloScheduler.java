package com.lwh.quartz.demo1;

import com.lwh.quartz.util.TimeUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        /** 创建一个JobDetail实例,将该实例与HelloJob Class绑定 **/
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("message", "hello myJob1")
                .usingJobData("floatJobValue", 3.14f)
                .build();

        /** 创建一个Trigger实例,定义该Job立即执行,并且每隔两秒钟重复执行一次,直到永远 **/
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .usingJobData("message", "hello myTrigger1")
                .usingJobData("doubleTriggerValue", 2.0d)
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        /** 创建Scheduler实例 **/
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        /** 打印当前时间 **/
        TimeUtil.printNowTime();

        /** 绑定 **/
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
