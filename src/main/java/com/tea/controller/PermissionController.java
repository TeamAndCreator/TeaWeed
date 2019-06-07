package com.tea.controller;


import com.tea.entity.Permission;
import com.tea.entity.Result;
import com.tea.service.PermissionService;
import com.tea.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @PostMapping(value = "save")
    //@RequiresRoles(value = "admin")
    public Result save(Permission permission){
        try {
            permissionService.save(permission);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @GetMapping(value = "findAll")
   //@RequiresRoles(value = "admin")
    public Result findAll(){
        try {
            List<Permission> permissions = permissionService.findAll();
            return ResultUtil.success(permissions);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }
}
