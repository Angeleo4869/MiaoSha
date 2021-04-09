package com.angeleo.sks.admin.dto;

import com.angeleo.sks.db.pojo.SksGoods;
import com.angeleo.sks.db.pojo.SksGoodsAttribute;
import com.angeleo.sks.db.pojo.SksGoodsProduct;
import com.angeleo.sks.db.pojo.SksGoodsSpecification;

public class GoodsAllinone {
    SksGoods goods;
    SksGoodsSpecification[] specifications;
    SksGoodsAttribute[] attributes;
    SksGoodsProduct[] products;

    public SksGoods getGoods() {
        return goods;
    }

    public void setGoods(SksGoods goods) {
        this.goods = goods;
    }

    public SksGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(SksGoodsProduct[] products) {
        this.products = products;
    }

    public SksGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(SksGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public SksGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(SksGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
