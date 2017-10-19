package com.yang.shop.service;

import com.yang.framework.util.DateStyle;
import com.yang.framework.util.DateUtil;
import com.yang.shop.dao.ManUserDao;
import com.yang.shop.entity.auth.ManUser;
import com.yang.shop.service.base.BaseSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.MD5Util;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-06-28.
 */
@Service
public class ManUserSvc extends BaseSvc {

    @Autowired
    private ManUserDao manUserDao;


    public ManUser register(String fullName,String email,String password){
        ManUser manUser = new ManUser();
        manUser.setUsername(fullName);
        manUser.setDispname(fullName);
        manUser.setEmail(email);
        String newPassword = MD5Util.MD5(password);
        manUser.setPassword(newPassword);
        String date = DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM_SS);
        manUser.setCreatedAt(date);
        manUser.setUpdatedAt(date);
        ManUser saveManUser = manUserDao.save(manUser);
        return saveManUser;
    }
    /**
     * 验证系统中是否有相同的用户名
     * @param name
     * @return
     */
    public Boolean checkName(String name){
        Boolean flag = false;
        if(!"".equals(name)){
            List<ManUser> list = manUserDao.findByUsername(name);
            if (list.size() > 0){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 验证系统中是否有相同的邮箱
     * @param email
     * @return
     */
    public Boolean checkEmail(String email){
        Boolean flag = false;
        if(!"".equals(email)){
            List<ManUser> list = manUserDao.findByEmail(email);
            if (list.size() > 0){
                flag = true;
            }
        }
        return flag;
    }

    public Boolean checkLogin(String email, String password){
        List<ManUser> list = manUserDao.findByEmail(email);
        if (list.size() == 1){
            ManUser user = list.get(0);
            String userPassword = user.getPassword();
            String loginPassword = MD5Util.MD5(password);
            if (userPassword.equals(loginPassword)){
                return true;
            }
            return false;
        }else{
            return false;
        }

    }

}
