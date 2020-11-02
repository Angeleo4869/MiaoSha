package com.leo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 管理登录模块
 * @author leo
 * @method doLogin()
 */
@Controller
public class AdminLoginController implements BaseController {

    @RequestMapping("/login")
    @ResponseBody
    public String doLogin(){
        return  "Hello";
    }

}
