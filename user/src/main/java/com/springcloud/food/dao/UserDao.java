package com.springcloud.food.dao;

import com.springcloud.food.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public List<User> findAll(@Param("index") int index, @Param("limit") int limit);
    public User findById(long id);
    public int count();
    public void save(User user);
    public void update(User user);
    public void deleteById(long id);
}
