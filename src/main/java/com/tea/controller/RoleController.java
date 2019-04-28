package com.tea.controller;

import com.tea.entity.Permission;
import com.tea.entity.Result;
import com.tea.entity.Role;
import com.tea.service.PermissionService;
import com.tea.service.RoleService;
import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @PostMapping(value = "save")
    public Result save(Role role,List<Integer> id_list){
        try {
            List<Permission> permissions = permissionService.findAll();
            Set<Permission> permissionSet = new HashSet<>();
            for (Integer id : id_list){
                for (Permission permission : permissions){
                    if (id.equals(permission.getId())){
                           permissionSet.add(permission);
                    }
                }
            }
            role.setPermissions(permissionSet);
            roleService.save(role);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @GetMapping(value = "findAll")
    public Result findAll(){
        try {
            List<Role> roles = roleService.findAll();
            return ResultUtil.success(roles);
        }catch (Exception e){
            return ResultUtil.error(500,e.getMessage());
        }
    }


}
