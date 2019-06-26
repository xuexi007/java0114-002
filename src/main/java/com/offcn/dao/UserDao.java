package com.offcn.dao;

import com.offcn.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
//****************************新增方法1************************************************
public User findByNameContaining(String keyword);

//开发者2新增方法

    public void demo3(String name);

    //开发者2新增demo1
    public String demo1();
}
