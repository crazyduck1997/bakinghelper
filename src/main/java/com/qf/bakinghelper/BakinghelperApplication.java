package com.qf.bakinghelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.bakinghelper.dao")
public class BakinghelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakinghelperApplication.class, args);
    }

}
