package com.yang.shop.controller;

//import com.pricegine.yang.util.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;


abstract public class BaseCtl {
    protected Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    protected MessageSource messageSource;
   /* @Autowired
    protected WebConfig webConfig;


    protected String getText(String key) {
        return getText(key, webConfig.getDefaultLocale());
    }
    protected String getText(String key, Locale locale) {
        return messageSource.getMessage(key, null, locale);
    }*/
}
