package com.angeleo.sks.db.mapper;

import java.util.List;

import com.angeleo.sks.db.pojo.SksSearchHistory;
import com.angeleo.sks.db.pojo.SksSearchHistoryExample;
import org.apache.ibatis.annotations.Param;
public interface SksSearchHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    long countByExample(SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int deleteByExample(SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int insert(SksSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int insertSelective(SksSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    SksSearchHistory selectOneByExample(SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    SksSearchHistory selectOneByExampleSelective(@Param("example") SksSearchHistoryExample example, @Param("selective") SksSearchHistory.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    List<SksSearchHistory> selectByExampleSelective(@Param("example") SksSearchHistoryExample example, @Param("selective") SksSearchHistory.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    List<SksSearchHistory> selectByExample(SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    SksSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SksSearchHistory.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    SksSearchHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    SksSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SksSearchHistory record, @Param("example") SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SksSearchHistory record, @Param("example") SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SksSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SksSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") SksSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sks_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}