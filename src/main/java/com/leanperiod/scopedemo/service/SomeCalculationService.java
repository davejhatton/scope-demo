package com.leanperiod.scopedemo.service;

import com.leanperiod.scopedemo.domain.ContextHolder;
import com.leanperiod.scopedemo.domain.LoadReport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SomeCalculationService {

    private ContextHolder contextHolder;

    public SomeCalculationService(ContextHolder contextHolder) {
        this.contextHolder = contextHolder;
    }

    public LoadReport calcSomething() {
        log.info("Returning context holder {} : in Thread {}", contextHolder, Thread.currentThread().getName());
        return new LoadReport(contextHolder.getRunId() + " : " + contextHolder.getSystemDate().toString() + " : in Thread " +  Thread.currentThread().getName());
    }
}
