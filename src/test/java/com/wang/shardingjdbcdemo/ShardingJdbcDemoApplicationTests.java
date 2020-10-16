package com.wang.shardingjdbcdemo;

import com.wang.shardingjdbcdemo.entity.User;
import com.wang.shardingjdbcdemo.mapper.TestMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingJdbcDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestMapper testMapper;


    @Test
    public void testInsertUser(){
        User u = new User();
        u.setCreateTime("2020-10-16 22:22:22");
        u.setUpdateTime("2020-10-16 22:22:22");
        u.setHouseId(3);
        u.setUserAge(33);
        u.setUserId(3);
        u.setUserName("three");

        testMapper.insertUser(u);




    }

}
