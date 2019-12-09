package com.springcloud.food.controller;

import com.springcloud.food.entity.Admin;
import com.springcloud.food.entity.User;
import com.springcloud.food.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountClientController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(String username, String password, String type, HttpSession session){
        Object account = accountFeign.login(username, password, type);
        LinkedHashMap<String,Object> hashMap= (LinkedHashMap<String, Object>) account;
        String result=null;
        if(account==null){
            result="login";
        }else{
            if(type.equals("user")){
                User user= new User();
                String idStr=hashMap.get("id").toString();
                long id =Long.parseLong(idStr);
                user.setId(id);
                String nickName= (String) hashMap.get("nickname");
                user.setNickname(nickName);
                session.setAttribute("user",user);
                result="index";
            }else{
                Admin admin= (Admin) account;
                session.setAttribute("admin",admin);
                result="";
            }
        }
        return result;
    }

//    private User convertUser(Account account){
//        User user = new User();
//        user.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
//        user.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
//        user.setGender(ReflectUtils.getFieldValue(account,"gender")+"");
//        user.setId((long)(ReflectUtils.getFieldValue(account,"id")));
//        user.setNickname(ReflectUtils.getFieldValue(account,"nickname")+"");
//        user.setRegisterdate((Date)(ReflectUtils.getFieldValue(account,"registerdate")));
//        user.setTelephone(ReflectUtils.getFieldValue(account,"telephone")+"");
//        return user;
//    }
//
//    private Admin convertAdmin(Account account){
//        Admin admin = new Admin();
//        admin.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
//        admin.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
//        admin.setId((long)(ReflectUtils.getFieldValue(account,"id")));
//        return admin;
//    }
}
