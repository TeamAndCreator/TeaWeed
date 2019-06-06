package com.tea.controller;

import com.tea.entity.Result;
import com.tea.entity.Role;
import com.tea.entity.User;
import com.tea.service.RoleService;
import com.tea.service.UserService;
import com.tea.util.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

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

//    @PostMapping(value = "register")
//    public Result register(User user){
//        try {
//            userService.save(user);
//            return ResultUtil.success();
//        }catch (DataIntegrityViolationException e){
//            e.printStackTrace();
//            return ResultUtil.error(500,"账号已存在");
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResultUtil.error(500,e.getMessage());
//        }
//    }

    @PostMapping(value = "findByPhoneNumber")
    public Result findByPhoneNumber(String phoneNumber){
        try {
            long startTime=System.currentTimeMillis();
            User user = userService.findByPhoneNumber(phoneNumber);
            long endTime=System.currentTimeMillis();
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
            return ResultUtil.success(user);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

    @PostMapping("register")
    public Result save(User user,@ApiParam(value = "给用户分配的角色Id", required = true) @RequestParam List<Integer> role_id_List) {
        try {
            if (userService.findByPhoneNumber(user.getPhoneNumber())!=null)
                return ResultUtil.error(500,"用户名已存在");
            //对密码进行md5两次加密，不加盐
            Object password = new SimpleHash("MD5", user.getPassword(), null, 2);
            user.setPassword(String.valueOf(password));
            //添加注册时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String createTime = sdf.format(new Date());
            user.setCreateTime(createTime);
            //添加角色
            List<Role> roleList=roleService.findAll();
            Set<Role> roleSet=new HashSet<>();
            for (int id:role_id_List){
                for (Role role: roleList){
                    if (role.getId()==id)
                        roleSet.add(role);
                }
            }
            if (roleSet.size()==0)
                return ResultUtil.error(500,"至少需要添加一个角色");
            user.setRoles(roleSet);
            //初始状态为有效
            user.setActive(1);
            userService.save(user);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(e.hashCode(),e.getMessage());
        }
    }
    @GetMapping(value = "findAll")
    public  Result findAll(){
        try {
            List users=userService.findAll();
            return ResultUtil.success(users);

        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }
    @DeleteMapping(value = "deleteById")

    public  Result deleteById(Integer id){
        try {
            userService.deleteById(id);
            return  ResultUtil.success();

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
            userService.deleteByIds(ids);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }

    }
    @PostMapping(value = "save")
    public Result save(User user){
        try {
            userService.save(user);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());

        }
    }
}
