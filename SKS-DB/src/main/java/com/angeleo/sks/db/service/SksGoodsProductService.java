package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.GoodsProductMapper;
import com.angeleo.sks.db.mapper.SksGoodsProductMapper;
import com.angeleo.sks.db.pojo.SksGoodsProduct;
import com.angeleo.sks.db.pojo.SksGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SksGoodsProductService {
    @Resource
    private SksGoodsProductMapper SksGoodsProductMapper;
    @Resource
    private GoodsProductMapper goodsProductMapper;

    public List<SksGoodsProduct> queryByGid(Integer gid) {
        SksGoodsProductExample example = new SksGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return SksGoodsProductMapper.selectByExample(example);
    }

    public SksGoodsProduct findById(Integer id) {
        return SksGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        SksGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(SksGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        SksGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        SksGoodsProductExample example = new SksGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) SksGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        SksGoodsProductExample example = new SksGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        SksGoodsProductMapper.logicalDeleteByExample(example);
    }

    public int addStock(Integer id, Short num){
        return goodsProductMapper.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProductMapper.reduceStock(id, num);
    }

    public void updateById(SksGoodsProduct product) {
        product.setUpdateTime(LocalDateTime.now());
        SksGoodsProductMapper.updateByPrimaryKeySelective(product);
    }
}