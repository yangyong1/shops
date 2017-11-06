package com.yang.shop.entity.auth;



import com.yang.framework.help.AutoIdModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ManRolePerm")
public class ManRolePerm extends AutoIdModel {

    protected  Long roleid;
    protected String permission;
    protected Integer state = 1;//0表示失效，1表示有效

    public ManRolePerm() {
    }

    public ManRolePerm(ManRolePerm other) {
        this.id = other.id;
        this.createdAt = other.createdAt;
        this.updatedAt = other.updatedAt;
        this.roleid = other.roleid;
        this.permission = other.permission;
        this.state = other.state;
    }

    public ManRolePerm createBase() {
        return new ManRolePerm(this);
    }

//  Getters/Setters
    @Column(name="roleid")
    public Long getRoleid() {
    return this.roleid;
}
    public void setRoleid(Long val) {
        this.roleid = val;
    }


    @Column(name="intro")

    public String getPermission() {
        return this.permission;
    }
    public void setPermission(String val) {
        this.permission = val;
    }

    @Column(name="state")

    public Integer getState() {
        return this.state;
    }
    public void setState(Integer val) {
        this.state = val;
    }
}