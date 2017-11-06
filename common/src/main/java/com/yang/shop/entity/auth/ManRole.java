package com.yang.shop.entity.auth;



import com.yang.framework.help.AutoIdModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ManRole")
public class ManRole extends AutoIdModel {

    protected  String name;
    protected String intro;
    protected Integer state = 1;//0表示失效，1表示有效

    public ManRole() {
    }

    public ManRole(ManRole other) {
        this.id = other.id;
        this.createdAt = other.createdAt;
        this.updatedAt = other.updatedAt;
        this.name = other.name;
        this.intro = other.intro;
        this.state = other.state;
    }

    public ManRole createBase() {
        return new ManRole(this);
    }

//  Getters/Setters

    @Column(name="name",length = 256)
    public String getName() {
        return this.name;
    }
    public void setName(String val) {
        this.name = val;
    }


    @Column(name="intro")

    public String getIntro() {
        return this.intro;
    }
    public void setIntro(String val) {
        this.intro = val;
    }

    @Column(name="state")

    public Integer getState() {
        return this.state;
    }
    public void setState(Integer val) {
        this.state = val;
    }
}