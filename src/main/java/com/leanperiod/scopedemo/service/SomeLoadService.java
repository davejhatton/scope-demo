package com.leanperiod.scopedemo.service;

import com.leanperiod.scopedemo.domain.ContextHolder;
import com.leanperiod.scopedemo.domain.LoadReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SomeLoadService {

    private ContextHolder contextHolder;

    public SomeLoadService(ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
    }

    public LoadReport loadSomething() {

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Returning context holder {} :  in Thread {}", contextHolder, Thread.currentThread().getName());
        return new LoadReport(contextHolder.getRunId() + " : " + contextHolder.getSystemDate().toString() + " : in Thread " +  Thread.currentThread().getName());
    }
}
