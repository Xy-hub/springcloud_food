package com.springcloud.food.dao;

import com.springcloud.food.entity.Type;

import java.util.List;

public interface TypeDao {
    public Type findById(long id);

    public List<Type> findAll();
}
