package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.Dorm;
import com.zhb.dormitoryservice.pojo.User;
import com.zhb.dormitoryservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dormitory")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 查询管理员信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/adminlist",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> adminlist() {
        Map<String,Object> map = new HashMap<>();
        List<User> list = userService.adminfindAll();
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist",list);
        return map;
    }

    /**
     * 查询用户人数
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getusercount",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> getUserCount() {
        Map<String,Object> map = new HashMap<>();
        List<User> list = userService.getUserCount();
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist", list);
        return map;
    }
}
