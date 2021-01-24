package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.User;
import com.zhb.dormitoryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dormitory")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String login() {
        System.out.println("go to register page");
        return "login";
    }

    @PostMapping(value = "/register")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map<String, Object> register(@RequestBody Map<String, String> data){
        System.out.println("go to register");
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setUserName(data.get("username"));
        user.setPassword(data.get("password"));
        user.setAge(Integer.parseInt(data.get("age")));
        user.setPhone(data.get("phone"));
        user.setEmail(data.get("email"));
        user.setSex(data.get("sex"));
        user.setId(Integer.parseInt(data.get("id")));
        user.setPermission(Integer.parseInt(data.get("permission")));
        try {
            userService.createUser(user);
            map.put("msg","获取成功");
            map.put("state",true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }
}

