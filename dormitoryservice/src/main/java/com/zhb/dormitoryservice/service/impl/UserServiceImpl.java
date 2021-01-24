package com.zhb.dormitoryservice.service.impl;

import com.zhb.dormitoryservice.dao.UserMapper;
import com.zhb.dormitoryservice.pojo.*;
import com.zhb.dormitoryservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    //查
    @Override
    public List<Dorm> dormfindAll() {
        // TODO Auto-generated method stub
        return userMapper.dormfindAll();
    }

    @Override
    public List<Damagething> damfindAll() {
        // TODO Auto-generated method stub
        return userMapper.damfindAll();
    }

    @Override
    public List<Score> scofindAll() {
        // TODO Auto-generated method stub
        return userMapper.scofindAll();
    }

    @Override
    public List<Visitors> visfindAll() {
        // TODO Auto-generated method stub
        return userMapper.visfindAll();
    }

    @Override
    public List<User> userfindAll() {
        // TODO Auto-generated method stub
        return userMapper.userfindAll();
    }

    @Override
    public List<Student> studentfindAll() {
        return userMapper.studentfindAll();
    }

    @Override
    public List<User> adminfindAll() {
        return userMapper.adminfindAll();
    }

    @Override
    public List<Student> studentfindkeyAll(String key) {
        return userMapper.studentfindkeyAll(key);
    }

    @Override
    public List<Score> scofindkeyAll(String key) {
        return userMapper.scofindkeyAll(key);
    }

    @Override
    public List<Dorm> dormfindkeyAll(String key) {
        return userMapper.dormfindkeyAll(key);
    }

    @Override
    public List<Visitors> visfindkeyAll(String key) {
        return userMapper.visfindkeyAll(key);
    }

    @Override
    public List<Damagething> damfindkeyAll(String key) {
        return userMapper.damfindkeyAll(key);
    }

    //增
    @Override
    public void dormsave(Dorm dorm) {

        if (dorm.getId() != null) {
            userMapper.dormupdate(dorm);
        } else {
            userMapper.dormsave(dorm);
        }
    }

    @Override
    public void damsave(Damagething dam) {
        // TODO Auto-generated method stub
        if (dam.getDa_id() != null) {
            userMapper.damupdate(dam);
        } else {
            userMapper.damsave(dam);
        }
    }

    @Override
    public void vissave(Visitors vis) {
        // TODO Auto-generated method stub
        if (vis.getId()!=null) {
            userMapper.visupdate(vis);
        } else {
            userMapper.vissave(vis);
        }
    }

    @Override
    public void scosave(Score sco) {
        // TODO Auto-generated method stub
        if (sco.getId() != null) {
            userMapper.scoupdate(sco);
        } else {
            userMapper.scosave(sco);
        }
    }

    @Override
    public void usersave(User user) {
        // TODO Auto-generated method stub
        if (user.getu_id() != null) {
            userMapper.userupdate(user);
        } else {
            userMapper.usersave(user);
        }
    }

    @Override
    public void stusave(Student student) {
        if (student.getS_id() != null) {
            userMapper.stuupdate(student);
        } else {
            userMapper.stusave(student);
        }
    }

    //删
    @Override
    public void delete(Integer[] id) {
        // TODO Auto-generated method stub
        userMapper.delete(id);
    }

    @Override
    public void damdelete(Integer[] da_id) {
        // TODO Auto-generated method stub
        userMapper.damdelete(da_id);
    }

    @Override
    public void scodelete(Integer[] id) {
        // TODO Auto-generated method stub
        userMapper.scodelete(id);
    }

    @Override
    public void visdelete(Integer[] id) {
        userMapper.visdelete(id);
    }

    @Override
    public void userdelete(Integer[] u_id) {
        // TODO Auto-generated method stub
        userMapper.userdelete(u_id);
    }

    @Override
    public void studelete(Integer[] id) {
        userMapper.studelete(id);
    }

    @Override
    public Dorm findById(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.findById(id);
    }

    @Override
    public Damagething damfindById(Integer da_id) {
        // TODO Auto-generated method stub
        return userMapper.damfindById(da_id);
    }

    @Override
    public Score scofindById(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.scofindById(id);
    }

    @Override
    public Visitors visfindById(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.visfindById(id);
    }

    @Override
    public User checkUser(String username, String pwd) {
        // TODO Auto-generated method stub
        return userMapper.checkuser(username, pwd);
    }

    @Override
    public User userfindById(Integer u_id) {
        // TODO Auto-generated method stub
        return userMapper.userfindById(u_id);
    }

    @Override
    public User getUserByName(String username) {
        // TODO Auto-generated method stub
        return userMapper.getUserByName(username);
    }

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public List<User> getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public List<Damagething> getDamCount() {
        return userMapper.getDamCount();
    }

    @Override
    public List<Day> getVisCount() {
        return userMapper.getVisCount();
    }

}
