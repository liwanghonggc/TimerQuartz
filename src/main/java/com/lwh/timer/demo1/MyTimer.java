package com.lwh.timer.demo1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer {

    public static void main(String[] args) {
        /** 1.创建一个Timer实例 **/
        Timer timer = new Timer();

        /** 2.创建一个MyTimerTask实例 **/
        MyTimerTask task = new MyTimerTask("lwh sayHello");

        /** 3.通过timer定时定频率调用task **/

        //timer.schedule(task, 2000L, 1000L);


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(calendar.getTime()));
        calendar.add(Calendar.SECOND, 3);

        /**
           schedule用法1
           public void schedule(TimerTask task, Date time)
           task任务,time首次执行任务的时间
           在时间等于或超过time的时候执行且仅执行一次task,如果所传时间小于当前时间立即执行
         */
        //timer.schedule(task, calendar.getTime());

        /**
           schedule用法2
           public void schedule(TimerTask task, Date firstTime, long period)
           task任务,firstTime首次执行任务的时间,period执行一次task的时间间隔,单位毫秒
           在时间等于或超过time的时候首次执行task,之后每隔period毫秒重复执行一次task
         */
        //timer.schedule(task, calendar.getTime(), 2000L);

        /**
           schedule用法3
           public void schedule(TimerTask task, long delay)
           task任务,delay延迟时间
           等待delay毫秒之后执行且仅执行一次task
         */
        //timer.schedule(task, 1000L);

        /**
           schedule用法4
           public void schedule(TimerTask task, long delay, long period)
           task任务,delay延迟时间,period执行一次task的时间间隔
           等待delay毫秒之后首次执行task,之后每隔period毫秒重复执行一次task
         */
        //timer.schedule(task, 1000L, 3000L);

        /**
           scheduleAtFixedRate用法1
           public void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
           task任务,firstTime首次执行任务的时间,period执行一次task的时间间隔,单位毫秒
           在时间等于或超过time的时候首次执行task,之后每隔period毫秒重复执行一次task
         */
        //timer.scheduleAtFixedRate(task, calendar.getTime(), 2000L);

        /**
           scheduleAtFixedRate用法2
           public void scheduleAtFixedRate(TimerTask task, long delay, long period)
           task任务,delay延迟时间,period执行一次task的时间间隔
           等待delay毫秒之后首次执行task,之后每隔period毫秒重复执行一次task
         */
        //timer.scheduleAtFixedRate(task, 2000L, 3000L);

        timer.schedule(task, 4000L);
        System.out.println("schedule time is: " + df.format(task.scheduledExecutionTime()));
    }
}
