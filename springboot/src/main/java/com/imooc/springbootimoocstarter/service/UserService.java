package com.imooc.springbootimoocstarter.service;

import com.imooc.springbootimoocstarter.pojo.SysUser;
import com.imooc.springbootimoocstarter.pojo.TestPojo1;
import com.imooc.springbootimoocstarter.pojo.TestRegion;

import java.util.List;

public interface UserService {
    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(String userId);

    public SysUser queryUserById(String userId);

    public List<SysUser> queryUserList(SysUser user);

    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    public SysUser queryUserByIdCustom(String userId);

    public void saveUserTransactional(SysUser user);
    public TestPojo1 queryTest();
    public List<TestRegion> queryRegion(String id);
}

