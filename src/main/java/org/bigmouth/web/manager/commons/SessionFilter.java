/*
 * 文件名称: AdminSessionFilter.java
 * 版权信息: Copyright 2005-2013 SKY-MOBI Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-3-30
 * 修改内容: 
 */
package org.bigmouth.web.manager.commons;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.RequestUtils;
import org.bigmouth.web.manager.master.entity.Admin;
import org.bigmouth.web.manager.utils.AdminSessionUtils;

public class SessionFilter implements Filter {

    private static final Logger logger = Logger.getLogger(SessionFilter.class);

    private String loginUrl;

    private String publicResources;
    
    private String ACTION_EXT_NAME = ".shtml";

    /**
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /**
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     *      javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
        checkRequestResponse(arg0, arg1);
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse resp = (HttpServletResponse) arg1;
        
        String[] url = formatUrlExt(request);
        if (checkPublicResource(url[1])) {
            logger.debug("+++++ 请求地址为公共资源，权限认证成功。");
            arg2.doFilter(arg0, arg1);
            return;
        }
        Admin admin = AdminSessionUtils.getSession(request);
        if (admin == null) {
            resp.sendRedirect(request.getContextPath() + loginUrl);
        }
        else {
            arg2.doFilter(arg0, arg1);
        }
    }

    /**
     * 判断Request ,Response 类型
     * 
     * @param request ServletRequest
     * @param response ServletResponse
     * @throws ServletException
     */
    private void checkRequestResponse(ServletRequest request, ServletResponse response) throws ServletException {
        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException("Can only process HttpServletRequest");

        }
        if (!(response instanceof HttpServletResponse)) {
            throw new ServletException("Can only process HttpServletResponse");
        }
    }

    private boolean checkPublicResource(String url) {
        if (StringUtils.isBlank(url))
            return false;
        String[] urls = StringUtils.splitByWholeSeparator(publicResources, ",");
        for (String s : urls) {
            if (url.trim().equals(s.trim())) {
                return true;
            }
        }
        return false;
    }
    
    private String[] formatUrlExt(HttpServletRequest request) {

        String nameSpace = "";
        String actionName = "";
        String method = "";
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        String uri = RequestUtils.getServletPath(request);
        String action = uri;
        // 去掉后缀
        if (!uri.endsWith(ACTION_EXT_NAME)) {
            return null;
        }
        else {
            uri = uri.substring(0, uri.lastIndexOf(ACTION_EXT_NAME));
        }
        int nextSlash = uri.indexOf('/', 1);
        if (nextSlash == -1) {
            return null;
        }
        String[] parse = uri.split("[///]");
        if (1 < parse.length) {
            nameSpace = uri.substring(1, nextSlash);
        }
        if (2 < parse.length) {
            actionName = parse[2];
        }
        if (3 < parse.length) {
            method = parse[3];
            int beginIndex = ("/" + nameSpace + "/" + actionName + "/" + method).length();
            try {
                if (uri.length() > beginIndex) {
                    StringTokenizer st = new StringTokenizer(uri.substring(beginIndex + 1), "/");
                    boolean isNameTok = true;
                    String paramName = null;
                    String paramValue;

                    // check if we have the first parameter name
                    if ((st.countTokens() % 2) != 0) {
                        isNameTok = false;
                        paramName = "id";
                    }

                    while (st.hasMoreTokens()) {
                        if (isNameTok) {
                            paramName = URLDecoder.decode(st.nextToken(), "UTF-8");
                            isNameTok = false;
                        }
                        else {
                            paramValue = URLDecoder.decode(st.nextToken(), "UTF-8");
                            if ((paramName != null) && (paramName.length() > 0)) {
                                parameters.put(paramName, paramValue);
                            }
                            isNameTok = true;
                        }
                    }
                }
            }
            catch (Exception e) {
                logger.warn("Cannot determine url parameters", e);
            }
        }
        action = "/" + nameSpace + "/" + actionName + ACTION_EXT_NAME;
        return new String[] { uri, action };
    }

    /**
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        loginUrl = arg0.getInitParameter("loginUrl");
        publicResources = arg0.getInitParameter("publicResources");
    }

}
