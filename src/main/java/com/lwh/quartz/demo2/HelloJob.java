package com.lwh.quartz.demo2;

import com.lwh.quartz.util.TimeUtil;
import org.quartz.*;


public class HelloJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /** 打印当前的执行时间 **/
        TimeUtil.printNowTime();

        /** 编写具体的业务逻辑 **/
        Trigger currentTrigger = context.getTrigger();
        System.out.println("Start time is: " + currentTrigger.getStartTime());
        System.out.println("End time is: " + currentTrigger.getEndTime());

    }
}
