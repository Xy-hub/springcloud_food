package com.springcloud.food.controller;

import com.springcloud.food.entity.*;
import com.springcloud.food.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserClientController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    //layui中传过来的参数，layui自动生成的
    public UserVO findAll(@RequestParam("page") int index, @RequestParam("limit") int limit){
        //分页设置
        index=(index-1)*limit;
        //调用通过feign调用menu服务的方法
        return userFeign.findAll(index,limit);
    }

    @GetMapping("/")
    public String index(){
        return "user_manage";
    }

    @GetMapping("/add")
    public String add(){
        return "user_add";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        System.out.println("删除："+id);
        userFeign.deleteById(id);
        return "redirect:/user/";
    }

    @PostMapping("/save")
    public String save(User user){
        userFeign.save(user);
        return "redirect:/user/";
    }

    @GetMapping("findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("user_update");
        User user =userFeign.findById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(User user){
        userFeign.update(user);
        return "redirect:/user/";
    }
}
