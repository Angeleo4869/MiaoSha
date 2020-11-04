package com.leo.admin;

import com.leo.admin.controller.AdminLoginController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leo
 */

@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);

        System.out.println("Hello World");
    }

}
