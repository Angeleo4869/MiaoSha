package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksAdmin;
import com.angeleo.sks.db.pojo.SksAdminExample;
import org.apache.ibatis.annotations.Param;


public interface SksAdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    long countByExample(SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int deleteByExample(SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int insert(SksAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int insertSelective(SksAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    SksAdmin selectOneByExample(SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    SksAdmin selectOneByExampleSelective(@Param("example") SksAdminExample example, @Param("selective") SksAdmin.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    List<SksAdmin> selectByExampleSelective(@Param("example") SksAdminExample example, @Param("selective") SksAdmin.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    List<SksAdmin> selectByExample(SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    SksAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksAdmin.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    SksAdmin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    SksAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksAdmin record, @Param("example") SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksAdmin record, @Param("example") SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksAdmin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksAdminExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_admin
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}