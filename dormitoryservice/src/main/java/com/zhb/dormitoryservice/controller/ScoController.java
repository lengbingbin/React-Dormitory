package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.Score;
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
public class ScoController {

    @Resource
    private UserService userService;

    /**
     * 查询损耗物品信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/scolist",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> scolist() {
        Map<String,Object> map = new HashMap<>();
        List<Score> list = userService.scofindAll();
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist",list);
        return map;
    }

    /**
     * 保存宿舍数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/scosave",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> scosave(@RequestBody Map<String, String> sco) {
        Score score = new Score();
        if(sco.get("id")!=""){
            score.setId(Integer.parseInt(sco.get("id")));
        }
        score.setDormid(Integer.parseInt(sco.get("dormid")));
        score.setScore(Integer.parseInt(sco.get("score")));
        List<Score> list;
        Map<String,Object> map = new HashMap<>();
        try {
            userService.scosave(score);
            list = userService.scofindAll();
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
    @RequestMapping(value = "/scofindById",method = RequestMethod.GET)
    @ResponseBody
    public Score scofindById(Integer id) {
        Score sco = userService.scofindById(id);
        return sco;
    }

    /**
     * 模糊查询学生信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/scosearchlist",method = RequestMethod.POST)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> scosearchlist(@RequestBody Map<String, String> data) {
        Map<String,Object> map = new HashMap<>();
        String key = data.get("dormid");
        List<Score> list = userService.scofindkeyAll(key);
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

    /**
     * 删除损耗物品信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/scodelete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> scodelete(@RequestBody List<Map<String, String>> data) {
        Integer[] id = new Integer[data.size()];
        List<Score> list;
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            id[i] = Integer.parseInt(data.get(i).get("id"));
        }
        try {
            userService.scodelete(id);
            list = userService.scofindAll();
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
}
