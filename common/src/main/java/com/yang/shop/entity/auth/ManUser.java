package com.yang.shop.entity.auth;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ManUser")
public class ManUser {

    protected  String username;

    protected String password;
    protected String dispName;
    protected String mobile;
    protected String mail;

    public ManUser() {
    }

    public ManUser(ManUser other) {
        this.username = other.username;
        this.password = other.password;
        this.dispName = other.dispName;
        this.mobile = other.mobile;
        this.mail = other.mail;
    }

    public ManUser createBase() {
        return new ManUser(this);
    }

//  Getters/Setters

    @Id
    @Column(name="username")
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

    public String getDispName() {
        return this.dispName;
    }
    public void setDispName(String val) {
        this.dispName = val;
    }

    @Column(name="mobile")

    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String val) {
        this.mobile = val;
    }

    @Column(name="mail")

    public String getMail() {
        return this.mail;
    }
    public void setMail(String val) {
        this.mail = val;
    }

}