package com.tea.controller;

import com.tea.entity.Result;
import com.tea.entity.Role;
import com.tea.entity.User;
import com.tea.service.UserService;
import com.tea.util.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 用户登录密码会先被MD5两次加密后再和数据库比对，
     * 所以数据库中的密码应是MD5两次加密后的密码
     *
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping(value = "login")
    public Result login(String userName, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        String jsessionid = (String) currentUser.getSession().getId();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(false);
        try {
            currentUser.login(token);
            currentUser.getSession().setAttribute("username",userName);
        } catch (UnknownAccountException ua) {
            System.out.println("未知账号！（提示：若已成功注册，请联系管理员查看用户是否已激活。）：" + ua.getMessage());
            return ResultUtil.error(500, "未知账号！（提示：若已成功注册，请联系管理员查看用户是否已激活。）");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("错误的凭证！：" + ice.getMessage());
            return ResultUtil.error(500, "错误的凭证!");
        } catch (LockedAccountException lae) {
            System.out.println("账号未激活！：" + lae.getMessage());
            return ResultUtil.error(500, "账号未激活!");
        } catch (ExcessiveAttemptsException eae) {
            System.out.println("错误次数过多！：" + eae.getMessage());
            return ResultUtil.error(500, "错误次数过多!");
        } catch (AuthenticationException ae) {
            System.out.println("验证未通过！:" + ae.getMessage());
//                return Msg.fail();
            return ResultUtil.error(500, "验证未通过!");
        }
        return ResultUtil.success(jsessionid);
    }



}
