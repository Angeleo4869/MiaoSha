package com.angeleo.sks.db;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.angeleo.sks.db"})
@MapperScan("com.angeleo.sks.db.mapper")
public class DbApplicationTests {
    public static void main(String[] args) {
        SpringApplication.run(DbApplicationTests.class, args);
    }

}
