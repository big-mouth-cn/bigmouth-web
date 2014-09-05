/*
 * 文件名称: AdminSessionUtils.java
 * 版权信息: Copyright 2005-2013 SKY-MOBI Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-3-30
 * 修改内容: 
 */
package org.bigmouth.web.manager.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bigmouth.framework.util.Struts2Utils;
import org.bigmouth.web.manager.master.entity.Admin;


/**
 * 管理员会话管理工具。
 * 
 * @author Allen.Hu / 2013-3-30
 */
public class AdminSessionUtils {
    
    public static final String SESSION_NAME = "Admin.Session";

    public static void putSession(Admin admin) {
        Struts2Utils.getSession().setAttribute(SESSION_NAME, admin);
    }
    
    public static Admin getSession() {
        return (Admin) Struts2Utils.getSession().getAttribute(SESSION_NAME);
    }
    
    public static Admin getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            return (Admin) session.getAttribute(SESSION_NAME);
        }
        return null;
    }
    
    public static void removeSession() {
        Struts2Utils.getSession().removeAttribute(SESSION_NAME);
    }
    
    public static void removeSession(HttpServletRequest request) {
        request.getSession().removeAttribute(SESSION_NAME);
    }
}
