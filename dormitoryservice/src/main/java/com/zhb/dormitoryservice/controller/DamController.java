package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.Damagething;
import com.zhb.dormitoryservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/dormitory")
public class DamController {

    @Resource
    private UserService userService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/damlist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> damlist() {
        Map<String, Object> map = new HashMap<>();
        List<Damagething> list = userService.damfindAll();
        map.put("msg", "获取成功");
        map.put("state", true);
        map.put("datalist", list);
        return map;
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/damsave",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> damsave(@RequestBody Map<String, String> dam) {
        Damagething damagething = new Damagething();
        String time = dam.get("damagetime");
        String date = time.substring(0,10);
        System.out.println("时间： " + date);
        if(dam.get("da_id")!=""){
            damagething.setDa_id(Integer.parseInt(dam.get("da_id")));
        }
        damagething.setDamagestation(dam.get("damagestation"));
        damagething.setDamagetime(date);
        damagething.setIsfixed(dam.get("isfixed"));
        damagething.setDormid(Integer.parseInt(dam.get("dormid")));
        Map<String, Object> map = new HashMap<>();
        List<Damagething> list = new ArrayList<>();
        try {

            userService.damsave(damagething);
            list = userService.damfindAll();
            map.put("msg", "获取成功");
            map.put("state", true);
            map.put("datalist", list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "保存失败");
        }
        return map;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/damfindById",method = RequestMethod.GET)
    @ResponseBody
    public Damagething findById(Integer da_id) {
        Damagething dam = userService.damfindById(da_id);
        return dam;
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/damdelete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> damdelete(@RequestBody List<Map<String, String>> dam) {
        Integer[] id = new Integer[dam.size()];
        List<Damagething> list;
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < dam.size(); i++) {
            id[i] = Integer.parseInt(dam.get(i).get("da_id"));
        }
        try {
            userService.damdelete(id);
            list = userService.damfindAll();
            map.put("msg", "获取成功");
            map.put("state", true);
            map.put("datalist", list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /**
     * 查询用户人数
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getdamcount",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> getUserCount() {
        Map<String,Object> map = new HashMap<>();
        List<Damagething> list = userService.getDamCount();
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist", list);
        return map;
    }

    /**
     * 模糊查询破损物品信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/damsearchlist",method = RequestMethod.POST)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> damsearchlist(@RequestBody Map<String, String> data) {
        Map<String,Object> map = new HashMap<>();
        String key = data.get("dormid");
        List<Damagething> list = userService.damfindkeyAll(key);
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
