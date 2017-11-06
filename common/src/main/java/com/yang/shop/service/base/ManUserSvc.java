package com.yang.shop.service.base;

import com.yang.framework.util.DateStyle;
import com.yang.framework.util.DateUtil;
import com.yang.shop.dao.ManUserRepo;
import com.yang.shop.entity.auth.ManUser;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.MD5Util;

import java.util.Date;
import java.util.List;

/**
* Auto generated file. Modify this file to extend functions.
* The service class of entity ManUser
*/
@Service
public class ManUserSvc extends BaseSvc {


    @Autowired
    private ManUserRepo repo;

    public void updatePassword(String password, String username) {
        repo.updatePasswd(password, username);
    }

    public ManUser findById(String id){

        return repo.findOne(id);
    }

    public List<ManUser> findAll(){
        return repo.findAll();
    }
    public Page<ManUser> listManUsers(int start,int pageSize){
        int page = start/pageSize;
        Pageable pageable = new PageRequest(page, pageSize);
        Page<ManUser> dataPage = repo.findAll(pageable);
        return dataPage;
    }

    public void save(ManUser entity) {
        String password = entity.getPassword();
        entity.setPassword(DigestUtils.md5Hex(password));
        repo.save(entity);
    }

    public void update(ManUser entity) {
        ManUser po = repo.findOne(entity.getUsername());
        po.setDispname(entity.getDispname());
        po.setMobile(entity.getMobile());
        String password = entity.getPassword();
        if(null!=password&&!"".equals(password.trim())){
            po.setPassword(DigestUtils.md5Hex(password));
        }

        repo.save(entity);
    }

    public void del(String userName) {
        repo.delete(userName);
    }


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
        ManUser saveManUser = repo.save(manUser);
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
            List<ManUser> list = repo.findByUsername(name);
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
            List<ManUser> list = repo.findByEmail(email);
            if (list.size() > 0){
                flag = true;
            }
        }
        return flag;
    }

    public Boolean checkLogin(String email, String password){
        List<ManUser> list = repo.findByEmail(email);
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
