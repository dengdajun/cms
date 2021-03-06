package com.davinci.shop.sys.user.service.impl;

import com.davinci.common.utils.EncryptDecrypt;
import com.davinci.core.exception.RedirectnException;
import com.davinci.shop.sys.user.mapper.SysUserMapper;
import com.davinci.shop.sys.user.model.SysUser;
import com.davinci.shop.sys.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dengdajun on 2017/2/12.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper mapper;
    @Override
    public SysUser getlogInUser(SysUser user) throws RedirectnException {
        SysUser entity=mapper.getUserByAccount(user.getAccount());
        if(entity==null){
            throw new RedirectnException("没有此账号");
        }
        if(!entity.getPasswd().equalsIgnoreCase(EncryptDecrypt.MD5(user.getPasswd()))){
            throw new RedirectnException("密码错误");
        }
        
         return entity;
    }
}
