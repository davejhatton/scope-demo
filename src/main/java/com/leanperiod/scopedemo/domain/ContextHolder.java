package com.leanperiod.scopedemo.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDate;

@Component
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@NoArgsConstructor(force = true)
public class ContextHolder {

    private String runId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate systemDate;
}
