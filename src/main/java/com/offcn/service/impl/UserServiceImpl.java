package com.offcn.service.impl;

import com.offcn.dao.UserDao;
import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @CacheEvict(value ={"findAll"},allEntries = true)
    public String createUser(User user) {
        return userDao.save(user)+"";
    }

    @Override
    @Cacheable(value = "findAll")
    public List<User> findAll() {
        //1、从redis缓存读取数据
        //2、判断缓存是否为空
        //3、如果缓存不为空，直接返回缓存结果
        //4、如果缓存为空，从数据库进行数据读取
        //5、读取完毕，把数据库结果写入到redis缓存
        //6、返回数据
        return userDao.findAll();
    }

    @Override
    public User findOneUser(Long id) {
        return userDao.findById(id).get();
    }

    @Override
    @CacheEvict(value ={"findAll"},allEntries = true)
    public String updateUserById(Long id, User user) {
        user.setId(id);
        return userDao.saveAndFlush(user)+"";
    }

    @Override
    @CacheEvict(value ={"findAll"},allEntries = true)
    public String deleteById(Long id) {
        userDao.deleteById(id);
        return "success";
    }
}
