package com.tea.configs;

import com.tea.entity.Permission;
import com.tea.entity.Role;
import com.tea.entity.User;
import com.tea.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 自定义权限匹配和账号密码匹配
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String phoneNumber = (String) principals.getPrimaryPrincipal();
        System.out.println(phoneNumber);
        User user=userService.findByPhoneNumber(phoneNumber);
        for (Role role : user.getRoles()) {
            authorizationInfo.addRole(role.getRoleName());
            for (Permission permission : role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getPermissionName());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) token;
        String phoneNumber=usernamePasswordToken.getUsername();
        User user = userService.findByPhoneNumber(phoneNumber);
        if (user == null) {
            return null;
        }else if (user.getActive() == 0) { //账户未激活
            throw new LockedAccountException();
        }else {
            SimpleAuthenticationInfo info = null;
            info = new SimpleAuthenticationInfo(user.getPhoneNumber(), user.getPassword(), getName());
            return info;
        }
    }

}
