package com.tea.controller;

import com.tea.entity.Result;
import com.tea.entity.Section;
import com.tea.service.SectionService;
import com.tea.util.ResultUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "section")
public class SectionController {
    @Resource
    private SectionService sectionService;
    @GetMapping(value = "getRegisterCode")
    public Result getRegisterCode(){
        try {
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }
    //查询所有
    @GetMapping(value = "findAll")
    public  Result findAll(){
        try {
            List section=sectionService.findAll();
            return ResultUtil.success(section);

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }
    //保存
    @PostMapping(value = "save")
    public Result save(Section section){
        try {

           sectionService.save(section);
            return ResultUtil.success();


        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());

        }
    }
    //单个删除
    @DeleteMapping(value = "deleteById")
    public  Result deleteById(Integer id){
        try {
            sectionService.deleteById(id);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }


    }
    //查询
    @GetMapping(value = "findById")
    public Result findById(Integer id){
        try {
           Section section = sectionService.findById(id);
            return ResultUtil.success(section);

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }

    }
    //    //批量删除
    @Transactional
    @DeleteMapping(value = "deleteByIds")
    public  Result deleteByIds(@ApiParam(name = "ids", value = "需删除属的id数组", required = true) @RequestParam(value ="ids")List<Integer> ids){
        try {
            sectionService.deleteByIds(ids);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }

    }

}
