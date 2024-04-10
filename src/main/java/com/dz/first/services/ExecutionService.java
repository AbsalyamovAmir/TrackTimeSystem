package com.dz.first.services;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.dz.first.annotation.TrackTime;
import com.dz.first.annotation.TrackTimeAsync;

@Service
public class ExecutionService {

    private final Random random = new Random();

    @TrackTime
    public void syncMethod() {
        int delay = random.nextInt(4000) + 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @TrackTimeAsync
    @Async
    public void asyncMethod() {
        int delay = random.nextInt(4000) + 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
