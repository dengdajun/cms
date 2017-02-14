package com.davinci.core.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.davinci.core.shiro.service.ShiroRealmService;
import com.davinci.shop.sys.user.model.SysUser;

/**
 * Created by YoungMan on 2017/1/28.
 */
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private ShiroRealmService shiroService;

    /**
     * 认证回调函数 登录时调用
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	 String account = (String) principalCollection.getPrimaryPrincipal(); //获取用户名
         SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
         authorizationInfo.setRoles(shiroService.getRolesByAccount(account));
         authorizationInfo.setStringPermissions(shiroService.getPermissionsByAccount(account));
         return authorizationInfo;
    }
    /**
     * 权限授权
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    	SysUser user=shiroService.getAccount(token.getUsername());
    	if( null!=user ) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPasswd(),getName());
            return authcInfo;
        } else {
            return null;
        }     
    }
}
