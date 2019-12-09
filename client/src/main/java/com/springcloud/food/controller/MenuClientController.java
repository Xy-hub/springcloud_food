package com.springcloud.food.controller;

import com.springcloud.food.entity.Menu;
import com.springcloud.food.entity.MenuVO;
import com.springcloud.food.entity.Type;
import com.springcloud.food.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuClientController {

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

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        System.out.println("删除："+id);
        menuFeign.deleteById(id);
        return "redirect:/menu/";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",menuFeign.findTypes());
        modelAndView.setViewName("menu_add.html");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/";
    }

    @GetMapping("findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_update");
        Menu menu =menuFeign.findById(id);
        modelAndView.addObject("menu",menu);
        List<Type> types = menuFeign.findTypes();
        modelAndView.addObject("list", types);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/";
    }
}
