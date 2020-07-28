package com.leanperiod.scopedemo.api;

import com.leanperiod.scopedemo.domain.ContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@Slf4j
public class RequestScopeConfiguration {

    @Bean
    @RequestScope
    public ContextHolder getContextHolder() {
        log.info("Creating context holder");
        return new ContextHolder();
    }
}
