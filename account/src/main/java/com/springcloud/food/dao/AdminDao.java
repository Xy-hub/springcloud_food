package com.springcloud.food.dao;

import com.springcloud.food.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    public Admin login(@Param("username") String username, @Param("password") String password);
}
