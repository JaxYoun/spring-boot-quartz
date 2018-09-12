package com.yang.springbootquartz.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: Yang
 * @date: 2018/9/13 00:30
 * @description:
 */
public class SampleJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("jjjjj");
    }
}
