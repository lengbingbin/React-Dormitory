package com.zhb.dormitoryservice.controller;

import com.zhb.dormitoryservice.pojo.Dorm;
import com.zhb.dormitoryservice.pojo.Student;
import com.zhb.dormitoryservice.service.UserService;
import com.zhb.dormitoryservice.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/dormitory")
public class StudentController {

    @Resource
    private UserService userService;

    /**
     * 查询学生信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/studentlist",method = RequestMethod.GET)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> studentlist() {
        Map<String,Object> map = new HashMap<>();
        List<Student> list = userService.studentfindAll();
        map.put("msg","获取成功");
        map.put("state",true);
        map.put("datalist",list);
        return map;
    }

    /**
     * 模糊查询学生信息(分页查询)
     *
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/stusearchlist",method = RequestMethod.POST)
    @ResponseBody        //用于转换对象为JSON
    public Map<String,Object> stusearchlist(@RequestBody Map<String, String> data) {
        Map<String,Object> map = new HashMap<>();
        String key = data.get("S_name");
        List<Student> list = userService.studentfindkeyAll(key);
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
     * 删除学生信息
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/studelete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> studelete(@RequestBody List<Map<String, String>> data) {
        System.out.println(data);
        Integer[] id = new Integer[data.size()];
        List<Student> list;
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            id[i] = Integer.parseInt(data.get(i).get("s_id"));
        }
        System.out.println("id:  "+id[0]);
        try {
            userService.studelete(id);
            list = userService.studentfindAll();
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
     * 保存学生数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/stusave",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> stusave(@RequestBody Map<String, String> data) {
        System.out.println(data);
        Student student = new Student();
        String birthday = TimeUtil.parseTime(data.get("birthday"));
        student.setS_id(Integer.parseInt(data.get("S_id")));
        student.setS_name(data.get("S_name"));
        student.setSex(data.get("sex"));
        student.setMobile(data.get("mobile"));
        student.setDormid(Integer.parseInt(data.get("dormid")));
        student.setBirthday(birthday);
        student.setQq(data.get("qq"));
        List<Student> list;
        Map<String,Object> map = new HashMap<>();
        try {
            userService.stusave(student);
            list = userService.studentfindAll();
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
