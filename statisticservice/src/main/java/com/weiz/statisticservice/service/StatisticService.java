package com.weiz.statisticservice.service;

import com.weiz.statisticservice.model.StatisticDTO;

import java.util.List;

public interface StatisticService {

    void add(StatisticDTO statisticDTO);

    List<StatisticDTO> getAll();
}
