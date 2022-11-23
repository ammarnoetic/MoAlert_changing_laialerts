package com.noetic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MultipleDataSourcesWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourcesWithSpringBootApplication.class, args);
    }
}
