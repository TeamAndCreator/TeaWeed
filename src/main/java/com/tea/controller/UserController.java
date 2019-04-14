package com.tea.controller;

import com.tea.entity.Result;
import com.tea.entity.User;
import com.tea.service.UserService;
import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "getRegisterCode")
    public Result getRegisterCode(){
        try {
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @PostMapping(value = "register")
    public Result register(User user){
        try {
            userService.save(user);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

}
