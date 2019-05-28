package com.tea.controller;

import com.tea.entity.Genus;
import com.tea.entity.Result;
import com.tea.entity.Role;
import com.tea.service.GenusService;
import com.tea.service.RoleService;
import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
}
