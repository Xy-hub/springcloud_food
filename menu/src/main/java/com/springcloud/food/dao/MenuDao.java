package com.springcloud.food.dao;

import com.springcloud.food.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    //查询所有，分页
    public List<Menu> findAll(@Param("index")int index, @Param("limit")int limit);
    public int count();
    public Menu findById(Long id);
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(Long id);
}
