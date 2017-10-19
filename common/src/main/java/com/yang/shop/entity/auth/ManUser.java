package com.yang.shop.entity.auth;



import com.yang.framework.help.AutoIdModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ManUser")
public class ManUser extends AutoIdModel {

    protected  String username;
    protected String password;
    protected String dispname;
    protected String mobile;
    protected String email;
    protected Integer state = 1;//0表示失效，1表示有效

    public ManUser() {
    }

    public ManUser(ManUser other) {
        this.id = other.id;
        this.createdAt = other.createdAt;
        this.updatedAt = other.updatedAt;
        this.username = other.username;
        this.password = other.password;
        this.dispname = other.dispname;
        this.mobile = other.mobile;
        this.email = other.email;
    }

    public ManUser createBase() {
        return new ManUser(this);
    }

//  Getters/Setters

    @Column(name="username",length = 256)
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String val) {
        this.username = val;
    }


    @Column(name="password")

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String val) {
        this.password = val;
    }

    @Column(name="disp_name")

    public String getDispname() {
        return this.dispname;
    }
    public void setDispname(String val) {
        this.dispname = val;
    }

    @Column(name="mobile")

    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String val) {
        this.mobile = val;
    }

    @Column(name="email")

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String val) {
        this.email = val;
    }

    @Column(name="state")

    public Integer getState() {
        return this.state;
    }
    public void setState(Integer val) {
        this.state = val;
    }
}