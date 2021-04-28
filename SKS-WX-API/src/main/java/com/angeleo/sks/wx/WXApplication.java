package com.angeleo.sks.wx;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author leo
 */
@SpringBootApplication(scanBasePackages = {"com.angeleo.sks.db", "com.angeleo.sks.core", "com.angeleo.sks.wx"})
@MapperScan("com.angeleo.sks.db.mapper")
@EnableTransactionManagement
@EnableScheduling
public class WXApplication {

    public static void main(String[] args) {
        SpringApplication.run(WXApplication.class, args);
    }

}