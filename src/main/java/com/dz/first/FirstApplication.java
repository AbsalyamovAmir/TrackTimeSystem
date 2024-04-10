package com.dz.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.dz.first.services.ExecutionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class FirstApplication {

	private final ExecutionService executionService;

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void onReady(){
		executionService.syncMethod();
		executionService.asyncMethod();
	}
}
