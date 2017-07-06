package com.yang.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by zen on 2015/2/4.
 */
@Controller
@RequestMapping("/index")
public class IndexCtl extends BaseCtl {

	/**
     * 404页面
     * @return
     */
    @RequestMapping("/notFound")
    public String notFound(){
        return "/error_404";
    }



}
