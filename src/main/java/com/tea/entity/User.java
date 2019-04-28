package com.tea.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Integer id;

    /*手机号（账号）*/
    @JoinColumn(nullable = false, unique = true)
    private
    String phoneNumber;

    /*密码*/
    private String password;

    /*创建时间*/
    private String createTime;

    /*是否激活 0.未激活 1.激活*/
    private Integer active;

    @ManyToMany(targetEntity = Role.class,fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }
}
