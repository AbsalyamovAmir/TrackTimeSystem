package com.dz.first.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dz.first.annotation.TrackTime;
import com.dz.first.services.StatisticService;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class TrackTimeAspect {
    
    @Autowired
    private StatisticService statisticService;

    @Before("@annotation(trackTime)")
    public void before(JoinPoint joinPoint, TrackTime trackTime) throws Exception {
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        statisticService.saveExecutionTimeData(methodName, startTime, 0);
        log.info(methodName);
    }
}
