package com.yang.springbootquartz.quartz.config;

import org.quartz.Job;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Yang
 * @date: 2018/9/12 23:02
 * @description:
 */
@Deprecated
//@Configuration
public class QuartzConfig {

//    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean (Job job) {
        return null;
    }

}
