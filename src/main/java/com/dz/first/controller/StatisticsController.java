package com.dz.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.first.entities.ExecutionData;
import com.dz.first.services.StatisticService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/average")
    public String getAverageExecutionTime() {
        double averageExecutionTime = statisticService.getAverageExecutionTime();
        return "Average execution time: " + averageExecutionTime + " ms";
    }

    @GetMapping("/total")
    public String getTotalExecutionTime() {
        long totalExecutionTime = statisticService.getTotalExecutionTime();
        return "Total execution time: " + totalExecutionTime + " ms";
    }

    @GetMapping("/all")
    public List<ExecutionData> getExecutionData() {
        return statisticService.getExecutionData();
    }
}