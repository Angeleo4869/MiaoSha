package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksFootprint;
import com.angeleo.sks.db.pojo.SksFootprintExample;
import org.apache.ibatis.annotations.Param;


public interface SksFootprintMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    long countByExample(SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int deleteByExample(SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int insert(SksFootprint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int insertSelective(SksFootprint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    SksFootprint selectOneByExample(SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    SksFootprint selectOneByExampleSelective(@Param("example") SksFootprintExample example, @Param("selective") SksFootprint.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    List<SksFootprint> selectByExampleSelective(@Param("example") SksFootprintExample example, @Param("selective") SksFootprint.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    List<SksFootprint> selectByExample(SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    SksFootprint selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksFootprint.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    SksFootprint selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    SksFootprint selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksFootprint record, @Param("example") SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksFootprint record, @Param("example") SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksFootprint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksFootprint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksFootprintExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_footprint
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}