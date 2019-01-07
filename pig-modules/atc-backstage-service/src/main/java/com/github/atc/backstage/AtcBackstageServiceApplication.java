package com.github.atc.backstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.github.atc.backstage", "com.github.pig.common.bean"})
public class AtcBackstageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtcBackstageServiceApplication.class, args);
    }

}

