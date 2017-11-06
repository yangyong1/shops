package com.yang.framework.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zen on 2015/1/29.
 */
public class FUtil {

    public static boolean isAjaxRequest(ServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }
}
