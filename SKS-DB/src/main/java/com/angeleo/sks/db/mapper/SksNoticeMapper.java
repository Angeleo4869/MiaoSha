package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksNotice;
import com.angeleo.sks.db.pojo.SksNoticeExample;
import org.apache.ibatis.annotations.Param;


public interface SksNoticeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    long countByExample(SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int deleteByExample(SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int insert(SksNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int insertSelective(SksNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    SksNotice selectOneByExample(SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    SksNotice selectOneByExampleSelective(@Param("example") SksNoticeExample example, @Param("selective") SksNotice.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    List<SksNotice> selectByExampleSelective(@Param("example") SksNoticeExample example, @Param("selective") SksNotice.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    List<SksNotice> selectByExample(SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    SksNotice selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksNotice.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    SksNotice selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    SksNotice selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksNotice record, @Param("example") SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksNotice record, @Param("example") SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksNotice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksNoticeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_notice
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}