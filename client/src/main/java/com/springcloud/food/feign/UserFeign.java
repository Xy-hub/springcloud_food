package com.springcloud.food.feign;

import com.springcloud.food.entity.Menu;
import com.springcloud.food.entity.Type;
import com.springcloud.food.entity.User;
import com.springcloud.food.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

    @DeleteMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @PostMapping("/user/save")
    public String save(User user);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @PutMapping("/user/update")
    public void update(User user);
}
