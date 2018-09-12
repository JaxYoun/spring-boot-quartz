package com.yang.springbootquartz.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author: Yang
 * @date: 2018/9/12 22:41
 * @description:
 */
@Deprecated
@Slf4j
@Component
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("MyJob------------->");
    }

}
