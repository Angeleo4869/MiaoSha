package com.angeleo.sks.db.service;

import com.angeleo.sks.db.mapper.SksSystemMapper;
import com.angeleo.sks.db.pojo.SksSystem;
import com.angeleo.sks.db.pojo.SksSystemExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SksSystemConfigService {
    @Resource
    private SksSystemMapper systemMapper;

    public Map<String, String> queryAll() {
        SksSystemExample example = new SksSystemExample();
        example.or().andDeletedEqualTo(false);

        List<SksSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> systemConfigs = new HashMap<>();
        for (SksSystem item : systemList) {
            systemConfigs.put(item.getKeyName(), item.getKeyValue());
        }

        return systemConfigs;
    }

    public Map<String, String> listMail() {
        SksSystemExample example = new SksSystemExample();
        example.or().andKeyNameLike("Sks_mall_%").andDeletedEqualTo(false);
        List<SksSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(SksSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listWx() {
        SksSystemExample example = new SksSystemExample();
        example.or().andKeyNameLike("Sks_wx_%").andDeletedEqualTo(false);
        List<SksSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(SksSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listOrder() {
        SksSystemExample example = new SksSystemExample();
        example.or().andKeyNameLike("Sks_order_%").andDeletedEqualTo(false);
        List<SksSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(SksSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public Map<String, String> listExpress() {
        SksSystemExample example = new SksSystemExample();
        example.or().andKeyNameLike("Sks_express_%").andDeletedEqualTo(false);
        List<SksSystem> systemList = systemMapper.selectByExample(example);
        Map<String, String> data = new HashMap<>();
        for(SksSystem system : systemList){
            data.put(system.getKeyName(), system.getKeyValue());
        }
        return data;
    }

    public void updateConfig(Map<String, String> data) {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            SksSystemExample example = new SksSystemExample();
            example.or().andKeyNameEqualTo(entry.getKey()).andDeletedEqualTo(false);

            SksSystem system = new SksSystem();
            system.setKeyName(entry.getKey());
            system.setKeyValue(entry.getValue());
            system.setUpdateTime(LocalDateTime.now());
            systemMapper.updateByExampleSelective(system, example);
        }

    }

    public void addConfig(String key, String value) {
        SksSystem system = new SksSystem();
        system.setKeyName(key);
        system.setKeyValue(value);
        system.setAddTime(LocalDateTime.now());
        system.setUpdateTime(LocalDateTime.now());
        systemMapper.insertSelective(system);
    }
}
