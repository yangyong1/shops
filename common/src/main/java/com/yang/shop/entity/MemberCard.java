package com.yang.shop.entity;

import com.yang.framework.help.AutoIdModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2015/4/7.
 */

@Entity
@Table(name="member_card")
public class MemberCard extends AutoIdModel{

    private String cardNo;
    private String phoneNumber;
    private String name;
    private String address;
    private String gender="0";//0为女性，1为男性
    private String email;
    private String birthday;
    private Long integration;
    private String level="1";
    private String isBind="1";//是否绑定手机号码，0为未绑定，1位绑定
    private String isEmailActivated="0";//邮箱是否激活
    private String barcode;//条形码
    private String isStop="0";//是否停用，0为未停用，1为停用
    private String isDel="0";//是否删除，0位未删除，1位已删除
    private int shopId;
    private String shopName;

    public MemberCard() {
    }

    public MemberCard(MemberCard other) {
        this.id = other.id;
        this.createdAt = other.createdAt;
        this.updatedAt = other.updatedAt;
        this.cardNo = other.cardNo;
        this.phoneNumber = other.phoneNumber;
        this.name = other.name;
        this.address = other.address;
        this.gender = other.gender;
        this.email = other.email;
        this.birthday = other.birthday;
        this.integration = other.integration;
        this.level = other.level;
        this.isBind = other.isBind;
        this.isEmailActivated = other.isEmailActivated;
        this.barcode = other.barcode;
        this.isStop = other.isStop;
        this.isDel = other.isDel;
        this.shopId = other.shopId;
        this.shopName = other.shopName;
    }

    @Column(name="card_no",length = 18,nullable = false,unique = true)

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    @Column(name="phone_number",length = 20,nullable = false,unique = true)

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name="name",length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="address",length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name="gender",length = 2)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Column(name="email",length = 100,unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name="birthday",length = 20)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    @Column(name="integration")
    public Long getIntegration() {
        return integration;
    }

    public void setIntegration(Long integration) {
        this.integration = integration;
    }
    @Column(name="level",length = 10)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    @Column(name="is_bind",length = 2)
    public String getIsBind() {
        return isBind;
    }

    public void setIsBind(String isBind) {
        this.isBind = isBind;
    }
    @Column(name="barcode",length = 100)
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    @Column(name="is_stop",length = 2)
    public String getIsStop() {
        return isStop;
    }

    public void setIsStop(String isStop) {
        this.isStop = isStop;
    }
    @Column(name="is_del",length = 2)
    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
    @Column(name="shop_id",nullable = false)
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
    @Column(name="is_email_activated",length = 2)
    public String getIsEmailActivated() {
        return isEmailActivated;
    }

    public void setIsEmailActivated(String isEmailActivated) {
        this.isEmailActivated = isEmailActivated;
    }
    @Column(name="shop_name",length = 100)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
