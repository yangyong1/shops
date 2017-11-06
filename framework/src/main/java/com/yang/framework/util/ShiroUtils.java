package com.yang.framework.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * This file is for .
 * User: Simon Xianyu
 * Date: 13-6-27
 * Time: 下午2:37
 */
public class ShiroUtils {

    public static final String DISPLAY_NAME = "displayname";

    /**
     * Get current user id from Shiro's subject.
     * @return login id
     */
    public static String getUsername() {
        Subject curuser = SecurityUtils.getSubject();
        Object o = curuser.getPrincipal();
        return null == o? "": o.toString();
    }

    public static String getDisplayName() {
        Subject curuser = SecurityUtils.getSubject();
        Object o = curuser.getSession(false).getAttribute(DISPLAY_NAME);
        return null==o?null : o.toString();
    }
}
