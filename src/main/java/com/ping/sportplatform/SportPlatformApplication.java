package com.ping.sportplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ping.sportplatform.mapper")
public class SportPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportPlatformApplication.class, args);
    }

}
