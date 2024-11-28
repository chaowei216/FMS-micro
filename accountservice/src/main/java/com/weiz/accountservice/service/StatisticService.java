package com.weiz.accountservice.service;

import com.weiz.accountservice.model.StatisticDTO;
import com.weiz.accountservice.service.impl.StatisticServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "statistic-service",
        fallback = StatisticServiceImpl.class
)
@Primary
public interface StatisticService {

    @PostMapping("/statistics")
    void add(@RequestBody StatisticDTO statisticDTO);
}
