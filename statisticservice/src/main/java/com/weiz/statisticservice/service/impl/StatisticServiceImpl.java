package com.weiz.statisticservice.service.impl;

import com.weiz.statisticservice.entity.Statistic;
import com.weiz.statisticservice.model.StatisticDTO;
import com.weiz.statisticservice.repository.StatisticRepository;
import com.weiz.statisticservice.service.StatisticService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;
    private final ModelMapper modelMapper;

    @Override
    public void add(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAll() {
        List<StatisticDTO> statisticDTOList = new ArrayList<>();

        statisticRepository.findAll().forEach(statistic -> {
            statisticDTOList.add(modelMapper.map(statistic, StatisticDTO.class));
        });

        return statisticDTOList;
    }
}
