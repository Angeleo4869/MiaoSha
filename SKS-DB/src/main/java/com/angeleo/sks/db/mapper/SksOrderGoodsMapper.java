package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksOrderGoods;
import com.angeleo.sks.db.pojo.SksOrderGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface SksOrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    long countByExample(SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int deleteByExample(SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int insert(SksOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int insertSelective(SksOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    SksOrderGoods selectOneByExample(SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    SksOrderGoods selectOneByExampleSelective(@Param("example") SksOrderGoodsExample example, @Param("selective") SksOrderGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    List<SksOrderGoods> selectByExampleSelective(@Param("example") SksOrderGoodsExample example, @Param("selective") SksOrderGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    List<SksOrderGoods> selectByExample(SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    SksOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksOrderGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    SksOrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    SksOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksOrderGoods record, @Param("example") SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksOrderGoods record, @Param("example") SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}