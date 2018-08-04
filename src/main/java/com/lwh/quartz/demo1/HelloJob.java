package com.lwh.quartz.demo1;

import com.lwh.quartz.util.TimeUtil;
import org.quartz.*;


public class HelloJob implements Job{

    private String message;

    private float floatJobValue;

    private double doubleTriggerValue;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getFloatJobValue() {
        return floatJobValue;
    }

    public void setFloatJobValue(float floatJobValue) {
        this.floatJobValue = floatJobValue;
    }

    public double getDoubleTriggerValue() {
        return doubleTriggerValue;
    }

    public void setDoubleTriggerValue(double doubleTriggerValue) {
        this.doubleTriggerValue = doubleTriggerValue;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /** 打印当前的执行时间 **/
        TimeUtil.printNowTime();

        /** 编写具体的业务逻辑 **/
        System.out.println("Hello World!");



        /** 获取context中jobDetail的数据 **/
        JobDetail jobDetail = context.getJobDetail();
        JobKey jobKey = jobDetail.getKey();
        System.out.println("My Job name and group are: " + jobKey.getName() + ", " + jobKey.getGroup());

        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        String jobMsg = jobDataMap.getString("message");
        float jobFloatValue = jobDataMap.getFloatValue("floatJobValue");
        System.out.println("jobMsg is: " + jobMsg + ", jobFloatValue is: " + jobFloatValue);

        /** 获取context中Trigger的数据 **/
        Trigger trigger = context.getTrigger();
        TriggerKey triggerKey = trigger.getKey();
        System.out.println("My trigger name and group are: " + triggerKey.getName() + ", " + triggerKey.getGroup());

        JobDataMap triggerDataMap = trigger.getJobDataMap();
        String triggerMsg = triggerDataMap.getString("message");
        double doubleTriggerValue = triggerDataMap.getDouble("doubleTriggerValue");
        System.out.println("triggerMsg is: " + triggerMsg + ", doubleTriggerValue is: " + doubleTriggerValue);

        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
    }
}
