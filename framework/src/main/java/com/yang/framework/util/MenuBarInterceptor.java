package com.yang.framework.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This file is for .
 * User: Simon Xianyu
 * Date: 13-6-20
 * Time: 上午11:59
 */
public class MenuBarInterceptor extends HandlerInterceptorAdapter
        implements HandlerInterceptor {

    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    private MenuBarSource menuBarSource;

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // check menu
        String lookupPath = this.urlPathHelper.getLookupPathForRequest(request);
        MenuItem main = menuBarSource.getMenuBar().findMain(lookupPath);
        if (main!=null) {
            request.setAttribute("mainMenuKey", main.getKey());
        }
    }

    public MenuBarSource getMenuBarSource() {
        return menuBarSource;
    }

    public void setMenuBarSource(MenuBarSource menuBarSource) {
        this.menuBarSource = menuBarSource;
    }
}
