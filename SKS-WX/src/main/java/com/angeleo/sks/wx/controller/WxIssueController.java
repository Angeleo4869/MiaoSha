package com.angeleo.sks.wx.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.core.util.ResponseUtil;
import com.angeleo.sks.core.validator.Order;
import com.angeleo.sks.core.validator.Sort;
import com.angeleo.sks.db.pojo.SksIssue;
import com.angeleo.sks.db.service.SksIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wx/issue")
@Validated
public class WxIssueController {
    private final Log logger = LogFactory.getLog(WxIssueController.class);

    @Autowired
    private SksIssueService issueService;

    /**
     * 帮助中心
     */
    @GetMapping("/list")
    public Object list(String question,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<SksIssue> issueList = issueService.querySelective(question, page, size, sort, order);
        return ResponseUtil.okList(issueList);
    }

}
