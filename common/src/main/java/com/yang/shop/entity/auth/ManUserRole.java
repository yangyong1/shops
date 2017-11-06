package com.yang.shop.entity.auth;



import com.yang.framework.help.AutoIdModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ManUserRole")
public class ManUserRole extends AutoIdModel {

    protected  Long roleid;
    protected Long userid;
    protected String username;
    protected Integer state = 1;//0表示失效，1表示有效

    public ManUserRole() {
    }

    public ManUserRole(ManUserRole other) {
        this.id = other.id;
        this.createdAt = other.createdAt;
        this.updatedAt = other.updatedAt;
        this.roleid = other.roleid;
        this.userid = other.userid;
        this.username = other.username;
        this.state = other.state;
    }

    public ManUserRole createBase() {
        return new ManUserRole(this);
    }

//  Getters/Setters

    @Column(name="roleid")
    public Long getRoleid() {
        return this.roleid;
    }
    public void setRoleid(Long val) {
        this.roleid = val;
    }

    @Column(name="userid")
    public Long getUserid() {
        return this.userid;
    }
    public void setUserid(Long val) {
        this.userid = val;
    }


    @Column(name="username")
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String val) {
        this.username = val;
    }

    @Column(name="state")
    public Integer getState() {
        return this.state;
    }
    public void setState(Integer val) {
        this.state = val;
    }
}