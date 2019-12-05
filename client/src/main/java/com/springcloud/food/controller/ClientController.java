package com.springcloud.food.controller;

import com.springcloud.food.entity.Menu;
import com.springcloud.food.entity.MenuVO;
import com.springcloud.food.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    //layui中传过来的参数，layui自动生成的
    public MenuVO findAll(@RequestParam("page") int index, @RequestParam("limit") int limit){
        //分页设置
        index=(index-1)*limit;
        //调用通过feign调用menu服务的方法
        return menuFeign.findAll(index,limit);
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
