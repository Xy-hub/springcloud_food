package com.springcloud.food.feign;

import com.springcloud.food.entity.Menu;
import com.springcloud.food.entity.MenuVO;
import com.springcloud.food.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * openfeign负载均衡， OpenFeign是Spring Cloud 在Feign的基础上支持了Spring MVC的注解，如@RequesMapping等等。
 * OpenFeign的@FeignClient可以解析SpringMVC的@RequestMapping注解下的接口，
 * 并通过动态代理的方式产生实现类，实现类中做负载均衡并调用其他服务。
 * 能够通过接口式编程调用服务
 */
@FeignClient(value="menu")  //会调用menu微服务中的方法
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public String save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") long id);

    @PostMapping("/menu/update")
    public void update(Menu menu);
}
