package com.hh.his.graduationproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.hh.his.graduationproject.dao")
public class HISApplication {

    public static void main(String[] args) {
        SpringApplication.run(HISApplication.class,args);
    }
}
