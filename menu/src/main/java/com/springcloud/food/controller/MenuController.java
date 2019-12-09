package com.springcloud.food.controller;

import com.springcloud.food.dao.MenuDao;
import com.springcloud.food.dao.TypeDao;
import com.springcloud.food.entity.Menu;
import com.springcloud.food.entity.MenuVO;
import com.springcloud.food.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    //配置文件中的值#{则是取的bean中的值}
    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private TypeDao typeDao;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<Menu> menuList = menuDao.findAll(index, limit);
        //总记录数
        int count =menuDao.count();
        MenuVO menuVO=new MenuVO(0,"",count,menuList);
        return menuVO;
    }

    @GetMapping("/count")
    public Integer count(){
        return menuDao.count();
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuDao.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        List<Type> list = typeDao.findAll();
        return list;
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){       //传过来的式json数据，用RequestBody进行解析，不然接收不到
        menuDao.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuDao.findById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Menu menu){     //传过来的式json数据，用RequestBody进行解析，不然接收不到
        menuDao.update(menu);
    }
}
