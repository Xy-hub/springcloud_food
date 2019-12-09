package com.springcloud.food.controller;

import com.springcloud.food.dao.AdminDao;
import com.springcloud.food.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminDao adminDao;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username,
                        @PathVariable("password")String password, @PathVariable("type")String type){
        Object object=null;
        if(type.equals("user")){
            object=userDao.login(username,password);
        }else{
            object=adminDao.login(username,password);
        }
        return object;
    }
}
