package com.tea.controller;

import com.tea.entity.File_database;
import com.tea.entity.Result;
import com.tea.service.File_databaseService;
import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "File_databaseService")
public class File_databaseController {

    @Resource
    private File_databaseService file_databaseService;


    @GetMapping(value = "findCount")
    public Result findCount(){
        try {
            Long count = file_databaseService.findCount();
            return ResultUtil.success(count);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @GetMapping(value = "page")
    public Result page(Integer start , Integer pageSize){
        try {
            List file_databases = file_databaseService.page(start,pageSize);
            return ResultUtil.success(file_databases);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

}
