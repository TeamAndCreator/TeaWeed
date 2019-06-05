package com.tea.controller;

import com.tea.entity.Genus;
import com.tea.entity.Result;
import com.tea.entity.Role;
import com.tea.service.GenusService;
import com.tea.service.RoleService;
import com.tea.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "genus")
public class GenusController {
    @Resource
    private GenusService genusService;
    @Resource
    private RoleService roleService;
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
            List genus=genusService.findAll();
            return ResultUtil.success(genus);

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }
    //保存
    @PostMapping(value = "save")
    public Result save(Genus genus){
        try {

            genusService.save(genus);
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
            genusService.deleteById(id);
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
            Genus genus = genusService.findById(id);
            return ResultUtil.success(genus);

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
         genusService.deleteByIds(ids);
           return ResultUtil.success();
    }catch (Exception e){
        e.printStackTrace();
           return ResultUtil.error(500,e.getMessage());
       }

   }
}
