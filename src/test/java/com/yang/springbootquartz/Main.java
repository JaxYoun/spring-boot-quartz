package com.yang.springbootquartz;

import com.yang.springbootquartz.quartz.job.MyJob;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Collection;

/**
 * @author: Yang
 * @date: 2018/9/12 22:37
 * @description:
 */
public class Main {

    @Test
    public void test0() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            //1.实例化调度器
            Scheduler scheduler = schedulerFactory.getScheduler();

            //2.实例化作业
            JobDetail jobDetail = JobBuilder
                    .newJob(MyJob.class)
                    .withIdentity("myJob1", "myJobGroup1")
                    .build();

            //3.实例化触发器
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("myTriger1", "myTrigerGroup1")
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2).withRepeatCount(10))
                    .startNow()
                    .build();

            Trigger trigger1 = TriggerBuilder
                    .newTrigger()
                    .withIdentity("myTriger1", "myTrigerGroup1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(String.valueOf("10/2 22-23 15 8 1 ? 2018")))
                    .startNow()
                    .build();

            //4.部署调度器
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
