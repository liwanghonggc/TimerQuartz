package com.lwh.quartz.simpletrigger;

import com.lwh.quartz.util.TimeUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;


public class HelloJob implements Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /** 打印当前的执行时间 **/
        TimeUtil.printNowTime();

        /** 编写具体的业务逻辑 **/
        System.out.println("lwh sayHello");

    }
}
