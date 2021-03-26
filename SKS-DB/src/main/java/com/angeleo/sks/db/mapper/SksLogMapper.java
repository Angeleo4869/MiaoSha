package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksLog;
import com.angeleo.sks.db.pojo.SksLogExample;
import org.apache.ibatis.annotations.Param;


public interface SksLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    long countByExample(SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int deleteByExample(SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int insert(SksLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int insertSelective(SksLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    SksLog selectOneByExample(SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    SksLog selectOneByExampleSelective(@Param("example") SksLogExample example, @Param("selective") SksLog.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    List<SksLog> selectByExampleSelective(@Param("example") SksLogExample example, @Param("selective") SksLog.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    List<SksLog> selectByExample(SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    SksLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksLog.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    SksLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    SksLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksLog record, @Param("example") SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksLog record, @Param("example") SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_log
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}