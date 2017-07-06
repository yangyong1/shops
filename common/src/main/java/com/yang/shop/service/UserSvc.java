package com.yang.shop.service;

import com.yang.shop.service.base.BaseSvc;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-06-28.
 */
@Service
public class UserSvc extends BaseSvc {

    public String getNameById() {

        int a = 1;

        String name = "yang";

        log.debug("根据用户id查询用户名");

        System.out.println("打印用户名");
        return name;
    }

}
