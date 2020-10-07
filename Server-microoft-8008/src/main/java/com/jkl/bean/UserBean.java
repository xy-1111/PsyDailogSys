package com.jkl.bean;

import javax.persistence.*;

/**
 * 用户实体类
 *
 * @author zhongxin
 * @since 2020-10-05
 */
@Entity
@Table(name = "tb_user")
public class UserBean {

//    @GenericGenerator(name = "idGenerator", strategy = "uuid")
//    @GeneratedValue(generator = "idGenerator")
//    主键采用UUID策略
//    @GenericGenerator是Hibernate提供的主键生成策略注解，注意下面的@GeneratedValue（JPA注解）使用generator = "idGenerator"引用了上面的name = "idGenerator"主键生成策略

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userId")//数据库字段名
    private int userId;

    @Column(name = "openId",length = 50)
    private String openId;

    @Column(name="loginAbleStatus",length = 1)
    private int loginAbleStatus;

    @Column(name="vip",length = 1)
    private int vip;

    @Column(name="phone",length = 20)
    private String phone;

    @Column(name="userName",length = 40)
    private String userName;

    @Column(name="gender",length = 1)
    private int gender;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getLoginAbleStatus() {
        return loginAbleStatus;
    }

    public void setLoginAbleStatus(int loginAbleStatus) {
        this.loginAbleStatus = loginAbleStatus;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
