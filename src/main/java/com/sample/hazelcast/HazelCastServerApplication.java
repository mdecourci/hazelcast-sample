package com.sample.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HazelCastServerApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "sample-hz-service");
        SpringApplication.run(HazelCastServerApplication.class, args);
    }
}
