package com.imooc.springbootimoocstarter.service.impl;

import com.github.pagehelper.PageHelper;
import com.imooc.springbootimoocstarter.mapper.SysUserMapper;
import com.imooc.springbootimoocstarter.mapper.SysUserMapperCustom;
import com.imooc.springbootimoocstarter.pojo.SysUser;
import com.imooc.springbootimoocstarter.pojo.TestPojo1;
import com.imooc.springbootimoocstarter.pojo.TestRegion;
import com.imooc.springbootimoocstarter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserMapperCustom userMapperCustom;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SysUser user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser user) {
        //更新修改的 其他变为空null ，selective则只更新修改的其他不变
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserById(String userId) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserList(SysUser user) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserByIdCustom(String userId) {
        List<SysUser> userlist=userMapperCustom.queryUserSimplyInfoById(userId);
        if (userlist !=null && !userlist.isEmpty()){
            return userlist.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(SysUser user) {
        userMapper.insert(user);
        int a=1/0;
        user.setIsDelete(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TestPojo1 queryTest() {
        TestPojo1 t=userMapperCustom.queryTest1();
        if(t !=null){
            return t;
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<TestRegion> queryRegion(String id) {
        List<TestRegion> t=userMapperCustom.queryRegion(id);
        if(t !=null){
            return t;
        }
        return null;
    }

}
