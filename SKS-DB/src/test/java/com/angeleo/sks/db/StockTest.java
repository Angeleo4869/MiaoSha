package com.angeleo.sks.db;

import com.angeleo.sks.db.mapper.GoodsProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockTest {
    @Autowired
    private GoodsProductMapper goodsProductMapper;

    @Test
    public void testReduceStock() {
        Integer id = 1;
        Short num = 10;
        goodsProductMapper.reduceStock(id, num);
    }

    @Test
    public void testAddStock() {
        Integer id = 1;
        Short num = 10;
        goodsProductMapper.addStock(id, num);
    }
}
