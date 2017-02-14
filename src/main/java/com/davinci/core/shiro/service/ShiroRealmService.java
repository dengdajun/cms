package com.davinci.core.shiro.service;

import java.util.Set;

import com.davinci.shop.sys.user.model.SysUser;

public interface ShiroRealmService {

	/**
	 * @param account 账号
	 * @return 通过账号获取角色
	 */
	Set<String> getRolesByAccount(String account);

	/**
	 * @param account 账号
	 * @return 通过真好获取授权
	 */
	Set<String> getPermissionsByAccount(String account);

	/**
	 * @param username 账号
	 * @return 通过账号获取用户
	 */
	SysUser getAccount(String account);

}
