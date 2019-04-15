package com.tea.controller;

import com.tea.entity.Result;
import com.tea.entity.User;
import com.tea.service.UserService;
import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping(value = "login")
    public Result login(User user){
        try {
            int code = userService.login(user);
            if (code == 2)
                return ResultUtil.error(2,"密码错误");
            else if (code == 0)
                return ResultUtil.error(0,"账号错误");
            else
                return ResultUtil.success(1,"登录成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }



}
