package com.yang.springbootquartz.rest;

import com.yang.springbootquartz.quartz.job.SampleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yang
 * @date: 2018/9/13 00:34
 * @description: spring-boot2.x版整合quartz
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private Scheduler scheduler;

    /**
     * 前端请求，开启cront调度任务
     *
     * @return
     * @throws SchedulerException
     */
    @GetMapping("/schedule")
    public Object schedule() throws SchedulerException {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        JobDetail jobDetail = JobBuilder.newJob(SampleJob.class).withIdentity("name", "group").build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("name", "group").withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        this.scheduler.scheduleJob(jobDetail, trigger);
        this.scheduler.start();
        return "success";
    }

}
