package com.springcloud.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    //layui的数据格式转换类
    //所有的属性都要与layui中定义的一致
    private int code;

    private String msg;

    private int count;

    private List<Menu> data;

}
