package com.leo.admin;

import com.leo.admin.pojo.MsaUser;
import com.leo.admin.service.impl.MsaUserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author leo
 */

@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
        System.out.println(new MsaUserServiceImpl().adminLogin(new MsaUser("leo","1qa!QA")));
        System.out.println("Hello World");
    }

}
