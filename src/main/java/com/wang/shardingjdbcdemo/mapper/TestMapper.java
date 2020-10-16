package com.wang.shardingjdbcdemo.mapper;

import com.wang.shardingjdbcdemo.entity.User;
import com.wang.shardingjdbcdemo.entity.UserDto;
import com.wang.shardingjdbcdemo.support.DS;
import com.wang.shardingjdbcdemo.support.DynamicDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: meng
 * @Date: 2020-10-16 15:57
 */
@Mapper
@Repository
public interface TestMapper {

    @DS(name = DynamicDataSource.shardingDataSource)
    void insertUser(User user);

    List<User> queryUserList(User user);

    List<UserDto> queryTestSubQuery(User user);


}
