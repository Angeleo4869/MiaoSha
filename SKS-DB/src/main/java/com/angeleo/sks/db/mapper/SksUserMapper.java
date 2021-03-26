package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksUser;
import com.angeleo.sks.db.pojo.SksUserExample;
import org.apache.ibatis.annotations.Param;

public interface SksUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    long countByExample(SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int deleteByExample(SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int insert(SksUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int insertSelective(SksUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    SksUser selectOneByExample(SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    SksUser selectOneByExampleSelective(@Param("example") SksUserExample example, @Param("selective") SksUser.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    List<SksUser> selectByExampleSelective(@Param("example") SksUserExample example, @Param("selective") SksUser.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    List<SksUser> selectByExample(SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    SksUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksUser.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    SksUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    SksUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksUser record, @Param("example") SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksUser record, @Param("example") SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_user
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}