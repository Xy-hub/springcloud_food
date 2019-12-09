package com.springcloud.food.controller;

import com.springcloud.food.dao.UserDao;
import com.springcloud.food.entity.User;
import com.springcloud.food.entity.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<User> userList = userDao.findAll(index, limit);
        //总记录数
        int count =userDao.count();
        UserVO userVO=new UserVO(0,"",count,userList);
        return userVO;
    }

    @GetMapping("/count")
    public Integer count(){
        return userDao.count();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userDao.deleteById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){       //传过来的式json数据，用RequestBody进行解析，不然接收不到
        user.setRegisterdate(new Date());
        userDao.save(user);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userDao.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){     //传过来的式json数据，用RequestBody进行解析，不然接收不到
        userDao.update(user);
    }
}
