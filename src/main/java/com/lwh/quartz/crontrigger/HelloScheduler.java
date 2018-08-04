package com.lwh.quartz.crontrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        /** 打印当前时间 **/
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current exec time is: " + df.format(date));

        /** 创建一个JobDetail实例,将该实例与HelloJob Class绑定 **/
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        /** 距离当前时间4秒钟之后首次执行任务,之后每隔两秒钟执行一次,重复4次 **/
        CronTrigger trigger = (CronTrigger)TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();

        /**
           1.2017年内每天10点15分触发一次
             0 15 10 ? * * 2017

           2.每天的14点整至14点59分55秒,以及18点整至18点59分55秒,每隔5秒钟触发一次
             0/5 * 14,18 * * ?

           3.每月周一至周五的10点15分触发一次

           4.每月最后一天的10点15分触发一次

           5.每月第三个周五的10点15分触发一次

         */
        /** 创建Scheduler实例 **/
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        /** 绑定 **/
        scheduler.scheduleJob(jobDetail, trigger);

        /** scheduler执行2秒后挂起 **/
        Thread.sleep(2000L);

        scheduler.standby();

        /** scheduler挂起3秒后继续执行 **/
        Thread.sleep(3000L);
        scheduler.start();

        /** true表示等待所有正在执行的job执行完毕之后再关闭scheduler,而false直接关闭 **/
        scheduler.shutdown(false);

    }
}
