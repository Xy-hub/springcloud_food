package com.springcloud.food.dao;

import com.springcloud.food.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    public User login(@Param("username") String username, @Param("password") String password);
}
