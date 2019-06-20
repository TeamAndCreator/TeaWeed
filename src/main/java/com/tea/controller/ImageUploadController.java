package com.tea.controller;

import com.tea.entity.Result;
import com.tea.entity.User;
import com.tea.service.File_databaseService;
import com.tea.service.UserService;
import com.tea.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "file")
public class ImageUploadController {

    @Resource
    private File_databaseService file_databaseService;

    @Resource
    private UserService userService;

    @PostMapping(value = "save")
    @RequiresPermissions(value = "picture_insert")
    public Result save(MultipartFile multipartFile, String test_result,String input_result,String type) {
        try {
            file_databaseService.save(multipartFile, test_result,input_result,type);
            return ResultUtil.success();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResultUtil.error(500,"请登录");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    @PutMapping(value = "update_input_result")
//    @RequiresRoles("customer")
    public Result update_input_result(Integer id, String input_result){
        try {
            file_databaseService.update_input_result(id, input_result);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }


}
