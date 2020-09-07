package com.chingand.dao;

import com.chingand.domain.User;

import java.util.List;

public interface IUserDao {

    //查询所有
    List<User> findAll();


    //查询1个
    User findById(Integer userId);





}
