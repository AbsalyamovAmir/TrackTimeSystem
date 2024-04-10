package com.dz.first.aspect;

import java.util.concurrent.CompletableFuture;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Async;

import com.dz.first.annotation.TrackTimeAsync;
import com.dz.first.services.StatisticService;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class TrackTimeAsyncAspect {
    
    @Autowired
    private StatisticService statisticService;

    @Async
    @Before("@annotation(trackTimeAsync)")
    public Object before(JoinPoint joinPoint, TrackTimeAsync trackTimeAsync) throws Exception {
        return CompletableFuture.runAsync(() -> {
            try {
                long startTime = System.currentTimeMillis();
                String methodName = joinPoint.getSignature().getName();
                statisticService.saveExecutionTimeData(methodName, startTime, 0);
            } catch (Throwable e) {
                log.error("Ошибка AsyncRunnerAspect", e);
            }
        });
        
    }
}
