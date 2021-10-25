package com.event.eventpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventPracticeApplication.class, args);
    }

}
