package com.chingand.test;

import com.chingand.dao.IUserDao;
import com.chingand.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

        @Before //用于在测试方法之前执行
        public void init()throws Exception{
            //1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建SqlSessionFactory工厂---包工队 ---给钱
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            //3.使用工厂生产SqlSession对象---解耦,不用new对象,不用每次重新部署
            session = factory.openSession();
            //4.使用SqlSession创建Dao接口的代理对象--不写dao实现类也能实现功能
            userDao = session.getMapper(IUserDao.class);
        }

        @After //用于在测试方法之后执行
        public void distroy()throws Exception{
            //提交事务
            session.commit();

            //6.释放资源
            session.close();
            in.close();
        }


        @Test //查询所有
        public void testFindAll(){
            List<User> users = userDao.findAll();
            for(User user : users){
                System.out.println("-------每个用户的信息---------");
                System.out.println(user);
                System.out.println(user.getAccounts());
            }
        }


    }










