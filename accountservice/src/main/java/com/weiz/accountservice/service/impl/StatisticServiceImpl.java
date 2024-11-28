package com.weiz.accountservice.service.impl;

import com.weiz.accountservice.model.StatisticDTO;
import com.weiz.accountservice.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StatisticServiceImpl implements StatisticService {

    @Override
    public void add(StatisticDTO statisticDTO) {
        log.error("Statistic service time out");
    }
}
