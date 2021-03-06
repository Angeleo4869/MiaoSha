package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksGoods;
import com.angeleo.sks.db.pojo.SksGoodsExample;
import org.apache.ibatis.annotations.Param;


public interface SksGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    long countByExample(SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int deleteByExample(SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int insert(SksGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int insertSelective(SksGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    SksGoods selectOneByExample(SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    SksGoods selectOneByExampleSelective(@Param("example") SksGoodsExample example, @Param("selective") SksGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    SksGoods selectOneByExampleWithBLOBs(SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    List<SksGoods> selectByExampleSelective(@Param("example") SksGoodsExample example, @Param("selective") SksGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    List<SksGoods> selectByExampleWithBLOBs(SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    List<SksGoods> selectByExample(SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    SksGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    SksGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    SksGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksGoods record, @Param("example") SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") SksGoods record, @Param("example") SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksGoods record, @Param("example") SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(SksGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}