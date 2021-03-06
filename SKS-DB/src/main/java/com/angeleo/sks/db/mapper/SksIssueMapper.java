package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksIssue;
import com.angeleo.sks.db.pojo.SksIssueExample;
import org.apache.ibatis.annotations.Param;

public interface SksIssueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    long countByExample(SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int deleteByExample(SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int insert(SksIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int insertSelective(SksIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    SksIssue selectOneByExample(SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    SksIssue selectOneByExampleSelective(@Param("example") SksIssueExample example, @Param("selective") SksIssue.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    List<SksIssue> selectByExampleSelective(@Param("example") SksIssueExample example, @Param("selective") SksIssue.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    List<SksIssue> selectByExample(SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    SksIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksIssue.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    SksIssue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    SksIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksIssue record, @Param("example") SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksIssue record, @Param("example") SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}