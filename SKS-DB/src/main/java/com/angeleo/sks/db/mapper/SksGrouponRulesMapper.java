package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksGrouponRules;
import com.angeleo.sks.db.pojo.SksGrouponRulesExample;
import org.apache.ibatis.annotations.Param;

public interface SksGrouponRulesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    long countByExample(SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int deleteByExample(SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int insert(SksGrouponRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int insertSelective(SksGrouponRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    SksGrouponRules selectOneByExample(SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    SksGrouponRules selectOneByExampleSelective(@Param("example") SksGrouponRulesExample example, @Param("selective") SksGrouponRules.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    List<SksGrouponRules> selectByExampleSelective(@Param("example") SksGrouponRulesExample example, @Param("selective") SksGrouponRules.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    List<SksGrouponRules> selectByExample(SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    SksGrouponRules selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksGrouponRules.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    SksGrouponRules selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    SksGrouponRules selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksGrouponRules record, @Param("example") SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksGrouponRules record, @Param("example") SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksGrouponRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksGrouponRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksGrouponRulesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_groupon_rules
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}