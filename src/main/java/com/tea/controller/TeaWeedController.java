package com.tea.controller;

import com.tea.entity.Result;
import com.tea.service.GrpcClientService;
import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value = "test")
public class TeaWeedController {

    @Resource
    GrpcClientService grpcClientService;

    @PostMapping(value = "tea_weed")
    public Result tea_weed(MultipartFile file){
        try {
            Map<String,Float> results = grpcClientService.tea_weed(file);
            return ResultUtil.success(results);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @PostMapping(value = "bamboo")
    public Result bamboo(MultipartFile file){
        try {
            Map<String,Float> results = grpcClientService.bamboo(file);
            return ResultUtil.success(results);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

}
