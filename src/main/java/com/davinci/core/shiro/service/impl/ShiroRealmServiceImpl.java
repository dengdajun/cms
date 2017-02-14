package com.davinci.core.shiro.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davinci.core.shiro.mapper.ShiroRealmMapper;
import com.davinci.core.shiro.service.ShiroRealmService;
import com.davinci.shop.sys.user.model.SysUser;

/**
 * @author YoungMan
 *
 */
@Service
public class ShiroRealmServiceImpl implements ShiroRealmService{
	@Autowired
	private ShiroRealmMapper shiromapper;

	@Override
	public Set<String> getRolesByAccount(String account) {
		return shiromapper.getRolesByAccount(account);
	}

	@Override
	public Set<String> getPermissionsByAccount(String account) {
		// TODO Auto-generated method stub
		return shiromapper.getPermissionsByAccount(account);
	}

	@Override
	public SysUser getAccount(String account) {
		// TODO Auto-generated method stub
		return shiromapper.getAccount(account);
	}

}
