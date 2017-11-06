package com.yang.shop.shiro;

import com.yang.framework.util.FUtil;
import com.yang.framework.util.ShiroUtils;
import com.yang.shop.dao.ManUserRepo;
import com.yang.shop.entity.auth.ManUser;
import com.yang.shop.service.base.ManUserSvc;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Customize filter to implement
 * Created by simon on 14-5-8.
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private ManUserSvc manUserSvc;
    @Autowired
    private ManUserRepo userRepo;


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token,
                                     Subject subject, ServletRequest request, ServletResponse response)
            throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (!FUtil.isAjaxRequest(request)) {// 不是ajax请求
            ManUser user = userRepo.findOne(token.getPrincipal().toString());
            if (null != user) {
                subject.getSession().setAttribute(ShiroUtils.DISPLAY_NAME, user.getDispname());
                ((HttpServletRequest)request).getSession().setAttribute(ShiroUtils.DISPLAY_NAME, user.getDispname());
//                user.setLastLoginTime(new Date());
//                manUserSvc.save(user);
            }
            issueSuccessRedirect(request, response);
        } else {
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.println("{success:true,message:'登入成功'}");
            out.flush();
            out.close();
        }
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        if (e instanceof UnknownAccountException) {
            request.setAttribute("errorKey", "login.bad.credential");
        } else if(e instanceof IncorrectCredentialsException) {
            request.setAttribute("errorKey", "login.bad.credential");
        } else {
            request.setAttribute("errorKey", "login.failed");
        }

        if (!isAjaxRequest( request )) {// 不是ajax请求
            request.setAttribute("loginFailed",true);
            request.setAttribute("message", "登录失败");
            setFailureAttribute(request, e);
            return true;
        }
        PrintWriter pw = null;
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            pw = response.getWriter();
            pw.print("{\"success\":false,\"code\":\"not-logined\"}");
            pw.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            IOUtils.closeQuietly(pw);
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            if (!isAjaxRequest( request ) ) {// 不是ajax请求
                saveRequestAndRedirectToLogin(request, response);
                return false;
            }
            PrintWriter pw = null;
            try {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                pw = response.getWriter();
                pw.print("{\"success\":false,\"code\":\"not-login\"}");
                pw.flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                IOUtils.closeQuietly(pw);
            }
        }
        return false;
    }

    private boolean isAjaxRequest(ServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request)
                .getHeader("X-Requested-With"));
    }
}
