package com.angeleo.sks.admin;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.angeleo.sks.core.qcode.QCodeService;
import com.angeleo.sks.db.pojo.SksGoods;
import com.angeleo.sks.db.service.SksGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CreateShareImageTest {
    @Autowired
    QCodeService qCodeService;
    @Autowired
    SksGoodsService leoGoodsService;

    @Test
    public void test() {
        SksGoods good = leoGoodsService.findById(1181010);
        qCodeService.createGoodShareImage(good.getId().toString(), good.getPicUrl(), good.getName());
    }
}
