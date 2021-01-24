package com.zhb.dormitoryservice.dao;


import com.zhb.dormitoryservice.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //查
    List<Dorm> dormfindAll();

    List<Damagething> damfindAll();

    List<Score> scofindAll();

    List<Visitors> visfindAll();

    List<User> userfindAll();

    List<Student> studentfindAll();

    List<User> adminfindAll();

    List<User> getUserCount();

    List<Damagething> getDamCount();

    List<Day> getVisCount();

    List<Student> studentfindkeyAll(String key);

    List<Score> scofindkeyAll(String key);

    List<Dorm> dormfindkeyAll(String key);

    List<Visitors> visfindkeyAll(String key);

    List<Damagething> damfindkeyAll(String key);

    //增
    void dormsave(Dorm dorm);

    void damsave(Damagething dam);

    void scosave(Score sco);

    void vissave(Visitors vis);

    void usersave(User user);

    void stusave(Student student);

    //删
    void delete(Integer[] id);

    void visdelete(Integer[] id);

    void scodelete(Integer[] id);

    void damdelete(Integer[] da_id);

    void userdelete(Integer[] u_id);

    void studelete(Integer[] id);

    //改
    void dormupdate(Dorm dorm);

    void damupdate(Damagething dam);

    void scoupdate(Score sco);

    void userupdate(User user);

    void stuupdate(Student student);

    void visupdate(Visitors vis);

    //数据回显，easy-ui版
    Damagething damfindById(Integer da_id);

    Dorm findById(Integer id);

    Score scofindById(Integer id);

    Visitors visfindById(Integer id);

    User userfindById(Integer u_id);

    User checkuser(@Param("username") String username, @Param("password") String password);

    User getUserByName(String username);

    void createUser(User user);

}
