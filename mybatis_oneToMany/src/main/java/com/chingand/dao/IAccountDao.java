package com.chingand.dao;

import com.chingand.domain.Account;
import com.chingand.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    //查询所有账户
    List<Account> findAll();

    //查询所有账户 带用户名 和 用户地址 信息
    List<AccountUser> findAllAccount();

}
