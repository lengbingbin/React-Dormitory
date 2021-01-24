package com.zhb.dormitoryservice.pojo;

public class User {

    private Integer id;
    private String userName;
    private String password;
    private int permission;
    private int age;
    private String sex;
    private Integer u_id;
    private String salt;
    private Long man;
    private Long woman;
    private Long total;
    private String phone;
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMan() {
        return man;
    }

    public void setMan(Long man) {
        this.man = man;
    }

    public Long getWoman() {
        return woman;
    }

    public void setWoman(Long woman) {
        this.woman = woman;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getu_id() {
        return u_id;
    }

    public void setu_id(Integer u_id) {
        this.u_id = u_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password="
                + password + ", permission=" + permission + ", age=" + age
                + ", sex=" + sex + ", u_id=" + u_id + ", salt=" + salt + "]";
    }


}
