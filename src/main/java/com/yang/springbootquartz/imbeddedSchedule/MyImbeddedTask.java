package com.yang.springbootquartz.imbeddedSchedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yang
 * @date: 2018/9/12 23:18
 * @description: 简单的单线程调度
 */
@Component
public class MyImbeddedTask {

    @Scheduled(cron = "1 * * * * *")
    public void cront() {
        System.out.println("cront------------->");
    }

    /**
     * 存在并行可能，上一次执行开始后，过一个周期就开始下一个，不管上一个是否执行完毕。
     */
    @Scheduled(fixedRate = 4000)
    public void fixedRate() {
        try {
            System.out.println(LocalDateTime.now().toString());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.interrupted();
        }
    }

    /**
     * 串行执行，即上一次执行结束后再过一个周期才执行下一次。
     */
    @Scheduled(fixedDelay = 2000)
    public void fixedDelay() {
        try {
            System.out.println(LocalDateTime.now().toString());
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.interrupted();
        }
    }

    /**
     * 初次延迟时间，即初次执行有一个等待期
     */
    @Scheduled(initialDelay = 5000, fixedDelay = 2000)
    public void initialDelay() {
        System.out.println("initialDelay------------>");
    }

}
