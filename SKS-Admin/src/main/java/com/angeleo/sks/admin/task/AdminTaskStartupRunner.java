package com.angeleo.sks.admin.task;

import com.angeleo.sks.core.task.TaskService;
import com.angeleo.sks.db.pojo.SksSnapUpRules;
import com.angeleo.sks.db.service.SksSnapUpRulesService;
import com.angeleo.sks.db.util.SnapUpConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class AdminTaskStartupRunner implements ApplicationRunner {

    @Autowired
    private SksSnapUpRulesService rulesService;
    @Autowired
    private TaskService taskService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<SksSnapUpRules> grouponRulesList = rulesService.queryByStatus(SnapUpConstant.RULE_STATUS_ON);
        for(SksSnapUpRules grouponRules : grouponRulesList){
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime expire =  grouponRules.getExpireTime();
            if(expire.isBefore(now)) {
                // 已经过期，则加入延迟队列
                taskService.addTask(new SnapUpRuleExpiredTask(grouponRules.getId(), 0));
            }
            else{
                // 还没过期，则加入延迟队列
                long delay = ChronoUnit.MILLIS.between(now, expire);
                taskService.addTask(new SnapUpRuleExpiredTask(grouponRules.getId(), delay));
            }
        }
    }
}