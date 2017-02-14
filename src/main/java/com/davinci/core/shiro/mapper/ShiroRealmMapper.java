package com.davinci.core.shiro.mapper;

import java.util.Set;

import com.davinci.core.mybatis.MyBatisInterface;
import com.davinci.shop.sys.user.model.SysUser;

/**
 * Created by YoungMan on 2017/2/12.
 */
@MyBatisInterface
public interface ShiroRealmMapper {

	Set<String> getRolesByAccount(String account);

	Set<String> getPermissionsByAccount(String account);

	SysUser getAccount(String account);

}
