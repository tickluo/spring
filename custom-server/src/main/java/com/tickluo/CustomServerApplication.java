package com.tickluo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@EnableAutoConfiguration
@Configuration
@ComponentScan
@SpringBootApplication
public class CustomServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomServerApplication.class, args);
    }
}
