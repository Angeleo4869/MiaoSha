package com.angeleo.sks.core;

import com.angeleo.sks.core.storage.TencentStorage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class TencentStorageTest {

    private Log logger = LogFactory.getLog(TencentStorageTest.class);
    @Autowired
    private TencentStorage tencentStorage;

    @Test
    public void test() throws IOException {
        String test = getClass().getClassLoader().getResource("sks.png").getFile();
        File testFile = new File(test);
        tencentStorage.store(new FileInputStream(test), testFile.length(), "image/png", "sks.png");
        Resource resource = tencentStorage.loadAsResource("sks.png");
        String url = tencentStorage.generateUrl("sks.png");
        logger.info("test file " + test);
        logger.info("store file " + resource.getURI());
        logger.info("generate url " + url);
    }

}