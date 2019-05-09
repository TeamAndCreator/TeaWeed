package com.tea.controller;

import com.tea.entity.Result;
import com.tea.service.File_databaseService;
import com.tea.service.GrpcClientService;
import com.tea.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TeaWeedController {

    @Resource
    GrpcClientService grpcClientService;

    @Resource
    File_databaseService file_databaseService;

    @PostMapping(value = "tea_weed")
    @RequiresRoles("customer")
    public Result tea_weed(MultipartFile file) {
        try {
            Map<String, Float> results = grpcClientService.tea_weed(file);
            Integer saved_file_database_id = file_databaseService.save(file, results.toString(), "tea_weed");
            Map result = new HashMap();
            result.put("saved_file_database_id", saved_file_database_id);
            result.put("test_result", results);
            return ResultUtil.success(result);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResultUtil.error(500, "请登录");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    @PostMapping(value = "bamboo")
    @RequiresRoles("customer")
    public Result bamboo(MultipartFile file) {
        try {
            Map<String, Float> results = grpcClientService.bamboo(file);
            Integer saved_file_database_id = file_databaseService.save(file, results.toString(), "bamboo");
            Map result = new HashMap();
            result.put("saved_file_database_id", saved_file_database_id);
            result.put("test_result", results);
            return ResultUtil.success(result);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResultUtil.error(500, "请登录");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

}
