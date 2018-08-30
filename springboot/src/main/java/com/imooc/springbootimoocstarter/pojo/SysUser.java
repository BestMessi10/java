package com.imooc.springbootimoocstarter.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    private Integer id;

    /**
     * 用户名，登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private Integer age;

    /**
     * 性别，012代表女男
     */
    private Integer sex;

    private String nickname;

    /**
     * 工作，1-11代表不同
     */
    private Integer job;

    /**
     * 头像地址
     */
    @Column(name = "face_image")
    private String faceImage;

    private String province;

    private String city;

    private String district;

    private String address;

    @Column(name = "auth_salt")
    private String authSalt;

    /**
     * 最后一次登录ip
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后一次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "is_delete")
    private Integer isDelete;

    @Column(name = "regist_time")
    private Date registTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名，登录名
     *
     * @return username - 用户名，登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名，登录名
     *
     * @param username 用户名，登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别，012代表女男
     *
     * @return sex - 性别，012代表女男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别，012代表女男
     *
     * @param sex 性别，012代表女男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取工作，1-11代表不同
     *
     * @return job - 工作，1-11代表不同
     */
    public Integer getJob() {
        return job;
    }

    /**
     * 设置工作，1-11代表不同
     *
     * @param job 工作，1-11代表不同
     */
    public void setJob(Integer job) {
        this.job = job;
    }

    /**
     * 获取头像地址
     *
     * @return face_image - 头像地址
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * 设置头像地址
     *
     * @param faceImage 头像地址
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return auth_salt
     */
    public String getAuthSalt() {
        return authSalt;
    }

    /**
     * @param authSalt
     */
    public void setAuthSalt(String authSalt) {
        this.authSalt = authSalt;
    }

    /**
     * 获取最后一次登录ip
     *
     * @return last_login_ip - 最后一次登录ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置最后一次登录ip
     *
     * @param lastLoginIp 最后一次登录ip
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取最后一次登录时间
     *
     * @return last_login_time - 最后一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后一次登录时间
     *
     * @param lastLoginTime 最后一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return is_delete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return regist_time
     */
    public Date getRegistTime() {
        return registTime;
    }

    /**
     * @param registTime
     */
    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }
}