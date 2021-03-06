package com.angeleo.sks.wx.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.angeleo.sks.core.util.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试服务
 * @author leo
 */
@RestController
@RequestMapping("/wx/index")
public class WxIndexController {
    private final Log logger = LogFactory.getLog(WxIndexController.class);

    /**
     * 测试数据
     *
     * @return 测试数据
     */
    @GetMapping("/index")
    public Object index() {
        return ResponseUtil.ok("hello world, this is wx service");
    }

}