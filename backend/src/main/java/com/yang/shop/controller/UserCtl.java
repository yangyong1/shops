package com.yang.shop.controller;

import com.yang.shop.service.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zen on 2015/2/4.
 */
@Controller
@RequestMapping("/user")
public class UserCtl extends BaseCtl {

	@Autowired
	private UserSvc usersvc; 

    /**
     *index
     * @param mav
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav){

        String name = usersvc.getNameById();
        return mav;
    }
    
    /**
     *index
     * @param mav
     * @return
     */
    @RequestMapping("/user/login")
    public ModelAndView login(ModelAndView mav){
  
        return mav;
    }


}
