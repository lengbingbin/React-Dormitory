package com.zhb.dormitoryservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.zhb.dormitoryservice.dao")
public class DormitoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormitoryserviceApplication.class, args);
    }

}
