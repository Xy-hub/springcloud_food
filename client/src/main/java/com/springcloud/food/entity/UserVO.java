package com.springcloud.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * 将实体类进行转换的类
 */
public class UserVO {
    //layui的数据格式转换类
    //layui中定义了的后台返回的数据格式必须式哪种，所有的属性都要与layui中要求的的一致，不然无法获取到数据
    private int code;

    private String msg;
    //数据的总记录数，用来分页的
    private int count;

    private List<User> data;

}
