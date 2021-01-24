package com.zhb.dormitoryservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zhb.dormitoryservice.pojo.Dorm;
import com.zhb.dormitoryservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dormitory")
public class DormController {

    @Resource
    private UserService userService;

    /**
     * 查询宿舍信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/dormlist",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> dormlist() {
        Map<String,Object> map = new HashMap<>();
        List<Dorm> list = userService.dormfindAll();
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist",list);
        return map;
    }

    /**
     * 保存宿舍数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/dormsave",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> dormsave(@RequestBody Map<String, String> data) {
        Dorm dorm = new Dorm();
        if(data.get("id")!=""){
            dorm.setId(Integer.parseInt(data.get("id")));
        }
        dorm.setD_id(Integer.parseInt(data.get("d_id")));
        dorm.setTotal(Integer.parseInt(data.get("total")));
        dorm.setUsed(Integer.parseInt(data.get("used")));
        dorm.setDormadmin(data.get("dormadmin"));
        List<Dorm> list;
        Map<String,Object> map = new HashMap<>();
        try {
            userService.dormsave(dorm);
            list = userService.dormfindAll();
            map.put("msg","获取成功");
            map.put("state",true);
            map.put("datalist",list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /**
     * 数据回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ResponseBody
    public Dorm findById(Integer id) {
        Dorm dorm = userService.findById(id);
        return dorm;
    }


    /**
     * 删除宿舍信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/dormdelete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> delete(@RequestBody List<Map<String, String>> data) {
        System.out.println(data);
        Integer[] id = new Integer[data.size()];
        List<Dorm> list;
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            id[i] = Integer.parseInt(data.get(i).get("id"));
        }
        System.out.println("id:  "+id[0]);
        try {
            userService.delete(id);
            list = userService.dormfindAll();
            map.put("msg","获取成功");
            map.put("state",true);
            map.put("datalist",list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /**
     * 模糊查询学生信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/dormsearchlist",method = RequestMethod.POST)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> dormsearchlist(@RequestBody Map<String, String> data) {
        Map<String,Object> map = new HashMap<>();
        String key = data.get("d_id");
        List<Dorm> list = userService.dormfindkeyAll(key);
        if(list.size()!=0){
            map.put("msg","获取成功");
            map.put("state",true);
            map.put("datalist",list);
        }else{
            map.put("msg","获取失败");
            map.put("state",false);
            map.put("datalist",list);
        }
        return map;
    }
}

