package com.zhb.dormitoryservice.service;


import com.zhb.dormitoryservice.pojo.*;

import java.util.List;

public interface UserService {


    //查
    List<Dorm> dormfindAll();

    List<Damagething> damfindAll();

    List<Score> scofindAll();

    List<Visitors> visfindAll();

    List<User> userfindAll();

    List<Student> studentfindAll();

    List<User> adminfindAll();

    List<Student> studentfindkeyAll(String key);

    List<Score> scofindkeyAll(String key);

    List<Dorm> dormfindkeyAll(String key);

    List<Visitors> visfindkeyAll(String key);

    List<Damagething> damfindkeyAll(String key);

    //增
    void stusave(Student student);

    void dormsave(Dorm dorm);

    void damsave(Damagething dam);

    void vissave(Visitors vis);

    void delete(Integer[] id);

    void scosave(Score sco);

    void usersave(User user);

    //删
    void damdelete(Integer[] da_id);

    void scodelete(Integer[] id);

    void visdelete(Integer[] id);

    void studelete(Integer[] id);

    void userdelete(Integer[] u_id);

    Dorm findById(Integer id);

    Damagething damfindById(Integer da_id);

    Score scofindById(Integer id);

    Visitors visfindById(Integer id);

    User checkUser(String username, String pwd);

    User userfindById(Integer u_id);

    User getUserByName(String username);

    void createUser(User user);

    List<User> getUserCount();

    List<Damagething> getDamCount();

    List<Day> getVisCount();

}
