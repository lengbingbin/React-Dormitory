package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.User;
import com.zhb.dormitoryservice.service.UserService;
import com.zhb.dormitoryservice.util.JWTUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/dormitory")
public class LoginController {

    @Resource
    private UserService userservice;
    private Map<String, Object> result = new HashMap<String, Object>();

    @GetMapping(value = "/login")
    public String login() {
        System.out.println("go to login page");
        return "login";
    }

    /**
     * 登录验证
     *
     * @param data
     * @return
     */
    @PostMapping(value = "/login")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
        System.out.println("go to login login");
        Map<String, String> payload = new HashMap<>();
        String username = data.get("username");
        String password = data.get("password");
        User user = userservice.checkUser(username, password);
        User getUserName = userservice.getUserByName(username);
        int permission = getUserName.getPermission();
        if (getUserName == null) {
            result.put("result", false);
            result.put("msg", "该用户不存在");
        } else if (user == null) {
            result.put("result", false);
            result.put("msg", "密码输入错误");
        } else {
            payload.put("username", user.getUserName());
            String token = JWTUtils.getToken(payload);
            result.put("token", token);
            result.put("result", true);
            result.put("per", permission);
        }
        return result;
    }

}

