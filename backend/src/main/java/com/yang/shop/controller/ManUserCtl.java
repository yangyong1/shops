package com.yang.shop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yang.shop.entity.auth.ManUser;
import com.yang.shop.service.ManUserSvc;
import com.yang.shop.service.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.BlockingDeque;

/**
 * Created by zen on 2015/2/4.
 */
@Controller
@RequestMapping("/manuser")
public class ManUserCtl extends BaseCtl {

	@Autowired
	private ManUserSvc manUserSvc;

    /**
     *index
     * @param mav
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mav){
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin(
            @RequestParam("email")String email,
            @RequestParam("password")String password){
        ModelAndView mav = new ModelAndView();

        Boolean loginFlag = manUserSvc.checkLogin(email,password);
        if(loginFlag){
            mav.addObject("message","登录成功");
        }else {
            mav.addObject("message","登录失败");
        }
        mav.setViewName("redirect:/manuser/login");

        return mav;
    }

    /**
     *index
     * @param mav
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register(ModelAndView mav){
        mav.setViewName("register");
        return mav;
    }

    /**
     * 注册
     * @param fullName
     * @param email
     * @param password
     * @param confirmPassword
     * @return
     */
    @RequestMapping("/toRegister")
    public ModelAndView toRegister(
            @RequestParam("fullName")String fullName,
            @RequestParam("email")String email,
            @RequestParam("password")String password,
            @RequestParam("confirmPassword")String confirmPassword){
        ModelAndView view = new ModelAndView();
        Boolean hasName = manUserSvc.checkName(fullName);
        Boolean hasEmail = manUserSvc.checkEmail(email);
        if(hasName){
            view.addObject("message", "用户名重复");
            view.setViewName("manuser/register");
        }else if(hasEmail){
            view.addObject("message", "邮箱重复");
            view.setViewName("manuser/register");
        }else if(!password.equals(confirmPassword)){
            view.addObject("message", "密码错误");
            view.setViewName("redirect:/manuser/register");
        }else{
            view.addObject("message","注册成功");
            view.setViewName("redirect:/manuser/register");
        }
        ManUser user = manUserSvc.register(fullName, email, password);

        return view;
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public Boolean checkName(@RequestParam("name")String name){

        Boolean hasName = manUserSvc.checkName(name);

        return hasName;
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public Boolean checkEmail(@RequestParam("email")String email){
        Boolean hasEmail = manUserSvc.checkEmail(email);
        return hasEmail;
    }
}
