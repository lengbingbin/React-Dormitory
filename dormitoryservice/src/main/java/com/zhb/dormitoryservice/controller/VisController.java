package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.Day;
import com.zhb.dormitoryservice.pojo.Visitors;
import com.zhb.dormitoryservice.service.UserService;
import com.zhb.dormitoryservice.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;


@Controller
@RequestMapping("/dormitory")
public class VisController {

    @Resource
    private UserService userService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/vislist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> vislist() {
        Map<String, Object> map = new HashMap<>();
        List<Visitors> list = userService.visfindAll();
        map.put("msg", "获取成功");
        map.put("state", true);
        map.put("datalist", list);
        return map;
    }

    /**
     * 增加数据
     * @param vis
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/vissave",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> vissave(@RequestBody Map<String, String> vis) {
        Visitors visitors = new Visitors();
        System.out.println("vis： " + vis);

        String starttime = TimeUtil.parseTime(vis.get("starttime"));
        String endtime = TimeUtil.parseTime(vis.get("endtime"));
        System.out.println("访问时间： " + starttime);
        System.out.println("访问时间： " + starttime);
        visitors.setVisitorname(vis.get("visitorname"));
        if(vis.get("id")!=""){
            visitors.setId(Integer.parseInt(vis.get("id")));
        }
        visitors.setStudentid(Integer.parseInt(vis.get("studentid")));
        visitors.setStarttime(starttime);
        visitors.setEndtime(endtime);
        visitors.setDay(vis.get("day"));
        List<Visitors> list;
        Map<String, Object> map = new HashMap<>();
        try {
            userService.vissave(visitors);
            list = userService.visfindAll();
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
     * 数据回显
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/visfindById",method = RequestMethod.GET)
    @ResponseBody
    public Visitors visfindById(Integer id) {
        Visitors vis = userService.visfindById(id);
        return vis;
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/visdelete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> visdelete(@RequestBody List<Map<String, String>> vis) {
        Integer[] id = new Integer[vis.size()];
        List<Visitors> list;
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < vis.size(); i++) {
            id[i] = Integer.parseInt(vis.get(i).get("id"));
        }
        try {
            userService.visdelete(id);
            list = userService.visfindAll();
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
     * 查询用户人数
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/getviscount",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> getVisCount() {
        Map<String,Object> map = new HashMap<>();
        List<Day> list1 = userService.getVisCount();
        System.out.println(list1);
        List<Integer> list = new LinkedList<>();
        list.add(Integer.parseInt(list1.get(0).getMon()));
        list.add(Integer.parseInt(list1.get(0).getTue()));
        list.add(Integer.parseInt(list1.get(0).getWed()));
        list.add(Integer.parseInt(list1.get(0).getThu()));
        list.add(Integer.parseInt(list1.get(0).getFri()));
        list.add(Integer.parseInt(list1.get(0).getSat()));
        list.add(Integer.parseInt(list1.get(0).getSun()));
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist", list);
        return map;
    }

    /**
     * 模糊查询学生信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/vissearchlist",method = RequestMethod.POST)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> stusearchlist(@RequestBody Map<String, String> data) {
        Map<String,Object> map = new HashMap<>();
        String key = data.get("studentid");
        List<Visitors> list = userService.visfindkeyAll(key);
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
