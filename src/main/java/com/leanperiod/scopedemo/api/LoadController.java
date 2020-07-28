package com.leanperiod.scopedemo.api;

import com.leanperiod.scopedemo.domain.ContextHolder;
import com.leanperiod.scopedemo.domain.LoadReport;
import com.leanperiod.scopedemo.service.SomeCalculationService;
import com.leanperiod.scopedemo.service.SomeLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Slf4j
public class LoadController {

    private SomeLoadService someLoadService;
    private SomeCalculationService someCalculationService;

    // Request scoped
    private ContextHolder contextHolder;


    public LoadController(SomeLoadService someLoadService, SomeCalculationService someCalculationService, ContextHolder contextHolder) {
        this.someLoadService = someLoadService;
        this.someCalculationService = someCalculationService;
        this.contextHolder = contextHolder;
    }

    @GetMapping("{runId}")
    public String getInfo(@PathVariable String runId) {
        return runId;
    }


    @PostMapping("load/{runId}/{systemDate}")
    public LoadReport load(ContextHolder contextHolder) {
        log.info("Post for load with {} in Thread : {}", contextHolder, Thread.currentThread().getName());
        this.contextHolder.setRunId(contextHolder.getRunId());
        this.contextHolder.setSystemDate(contextHolder.getSystemDate());

        return someLoadService.loadSomething();
    }

    @PostMapping("calc/{runId}/{systemDate}")
    public LoadReport calc(@PathVariable String runId,
                           @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate systemDate) {
        log.info("Post for calc with {} in Thread : {}", runId + " : " + systemDate, Thread.currentThread().getName());
        this.contextHolder.setRunId(runId);
        this.contextHolder.setSystemDate(systemDate);

        return someCalculationService.calcSomething();
    }
}
