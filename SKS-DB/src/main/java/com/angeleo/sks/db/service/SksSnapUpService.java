package com.angeleo.sks.db.service;

import com.alibaba.druid.util.StringUtils;
import com.angeleo.sks.db.mapper.SksSnapUpMapper;
import com.angeleo.sks.db.pojo.SksSnapUp;
import com.angeleo.sks.db.pojo.SksSnapUpExample;
import com.angeleo.sks.db.util.SnapUpConstant;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author leo
 */
@Service
public class SksSnapUpService {
    @Resource
    private SksSnapUpMapper mapper;

    /**
     * 获取用户参加的秒杀记录
     *
     * @param: userId
     * @return: List
     */
    public List<SksSnapUp> queryMySnapUp(Integer userId) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andUserIdEqualTo(userId).andStatusNotEqualTo(SnapUpConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 获取用户参与的秒杀记录
     *
     * @param: userId
     * @return: List
     */
    public List<SksSnapUp> queryMyJoinSnapUp(Integer userId) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andUserIdEqualTo(userId).andStatusNotEqualTo(SnapUpConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据OrderId查询秒杀记录
     *
     * @param: orderId
     * @return:
     */
    public SksSnapUp queryByOrderId(Integer orderId) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 获取某个秒杀活动参与的记录
     *
     * @param: id
     * @return:
     */
    public List<SksSnapUp> queryJoinRecord(Integer id) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andStatusNotEqualTo(SnapUpConstant.STATUS_NONE).andDeletedEqualTo(false);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param: id
     * @return:
     */
    public SksSnapUp queryById(Integer id) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 根据ID查询记录
     *
     * @param: userId
     * @param: id
     * @return:
     */
    public SksSnapUp queryById(Integer userId, Integer id) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 返回某个发起的秒杀参与人数
     *
     * @param: snapupId
     * @return:
     */
    public int countSnapUp(Integer snapupId) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andStatusNotEqualTo(SnapUpConstant.STATUS_NONE).andDeletedEqualTo(false);
        return (int) mapper.countByExample(example);
    }

    public boolean hasJoin(Integer userId, Integer snapupId) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andUserIdEqualTo(userId).andStatusNotEqualTo(SnapUpConstant.STATUS_NONE).andDeletedEqualTo(false);
        return  mapper.countByExample(example) != 0;
    }

    public int updateById(SksSnapUp snapup) {
        snapup.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(snapup);
    }

    /**
     * 创建或参与一个秒杀
     *
     * @param: snapup
     * @return: int
     */
    public int createSnapUp(SksSnapUp snapup) {
        snapup.setAddTime(LocalDateTime.now());
        snapup.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(snapup);
    }


    /**
     * 查询所有发起的秒杀记录
     *
     * @param: rulesId
     * @param: page
     * @param: size
     * @param: sort
     * @param: order
     * @return: List
     */
    public List<SksSnapUp> querySelective(String rulesId, Integer page, Integer size, String sort, String order) {
        SksSnapUpExample example = new SksSnapUpExample();
        SksSnapUpExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(rulesId)) {
            criteria.andRulesIdEqualTo(Integer.parseInt(rulesId));
        }
        criteria.andDeletedEqualTo(false);
        criteria.andStatusNotEqualTo(SnapUpConstant.STATUS_NONE);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public List<SksSnapUp> queryByRuleId(int snapupRuleId) {
        SksSnapUpExample example = new SksSnapUpExample();
        example.or().andRulesIdEqualTo(snapupRuleId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }
}
