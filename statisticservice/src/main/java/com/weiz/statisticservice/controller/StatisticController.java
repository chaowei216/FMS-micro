package com.weiz.statisticservice.controller;

import com.weiz.statisticservice.model.StatisticDTO;
import com.weiz.statisticservice.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@Slf4j
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @PreAuthorize("hasAuthority('SCOPE_log')")
    @PostMapping
    public StatisticDTO add(@RequestBody StatisticDTO statisticDTO) {
        log.info("Add statistic: {}", statisticDTO);

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        statisticService.add(statisticDTO);
        return statisticDTO;
    }

    @PreAuthorize("hasAuthority('SCOPE_read') && hasRole('ADMIN')")
    @GetMapping
    public List<StatisticDTO> getStatistics() {
        log.info("Get statistics");

        return statisticService.getAll();
    }
}
