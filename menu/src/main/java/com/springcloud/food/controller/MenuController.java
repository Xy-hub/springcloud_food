package com.springcloud.food.controller;

import com.springcloud.food.dao.MenuDao;
import com.springcloud.food.entity.Menu;
import com.springcloud.food.entity.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    //配置文件中的值#{则是取的bean中的值}
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuDao menuDao;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<Menu> menuList = menuDao.findAll(index, limit);
        MenuVO menuVO=new MenuVO(0,"",100,menuList);
        return menuVO;
    }

    @GetMapping("/count")
    public Integer count(){
        return menuDao.count();
    }
}
