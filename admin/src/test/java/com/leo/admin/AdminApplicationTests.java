package com.leo.admin;

import com.leo.admin.mapper.MsaUserMapper;
import com.leo.admin.pojo.MsaUser;
import com.leo.admin.service.impl.MsaUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {

    @Test
    void contextLoads() {
        MsaUserMapper msaUserMapper = null;
        MsaUser user = new MsaUser("leo","1qa!QA");
        System.out.println(user.toString());
        System.out.println(
                msaUserMapper.selectAll()
        );
//        System.out.println(new MsaUserServiceImpl().adminLogin(user));
    }

}
