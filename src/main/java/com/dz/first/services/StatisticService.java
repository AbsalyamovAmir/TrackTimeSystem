package com.dz.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.dz.first.entities.ExecutionData;
import com.dz.first.repositories.ExecutionDataRepository;

import jakarta.transaction.Transactional;

@Service
public class StatisticService {
    
    @Autowired
    private ExecutionDataRepository repository;

    @Async
    @Transactional
    public void saveExecutionTimeData(String methodName, long startTime, long endTime) {
        ExecutionData executionData = new ExecutionData();
        executionData.setMethodName(methodName);
        executionData.setStartTime(startTime);
        executionData.setEndTime(endTime);
        repository.save(executionData);
    }

    public double getAverageExecutionTime() {
        Double averageExecutionTime = repository.findAverageExecutionTime();
        return averageExecutionTime != null ? averageExecutionTime : 0.0;
    }

    public long getTotalExecutionTime() {
        Long totalExecutionTime = repository.findTotalExecutionTime();
        return totalExecutionTime != null ? totalExecutionTime : 0;
    }
    
    public List<ExecutionData> getExecutionData() {
        return repository.findAll();
    }
}
