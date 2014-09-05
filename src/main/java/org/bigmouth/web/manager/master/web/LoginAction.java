/*
 * 文件名称: LoginAction.java
 * 版权信息: Copyright 2005-2013 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-6-22
 * 修改内容: 
 */
package org.bigmouth.web.manager.master.web;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.master.entity.Admin;
import org.bigmouth.web.manager.master.service.AdminService;
import org.bigmouth.web.manager.utils.AdminSessionUtils;

@Namespace("/base")
@Action("auth")
@Results({ 
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/login.jsp"),
    @Result(name = LoginAction.ResultName.LOGIN_SUCCESS, location = "/manage/home.shtml", type = "redirect")
})
public class LoginAction extends JsonActionSupport {
    
    private final static Logger logger = Logger.getLogger(LoginAction.class);

    private static final long serialVersionUID = -5983912858220862407L;

    private AdminService adminService;

    @Override
    public String execute() {
        return JsonActionSupport.SUCCESS;
    }

    public String login() {
        try {
            String loginName = getParameter("loginName");
            String password = getParameter("password");
            Admin entity = new Admin();
            entity.setLoginName(loginName);
            entity.setPassword(password);
            Admin admin = adminService.login(entity);
            if (null != admin) {
                AdminSessionUtils.putSession(admin);
                return LoginAction.ResultName.LOGIN_SUCCESS;
            }
            return JsonActionSupport.SUCCESS;
        }
        catch (Exception e) {
            logger.error(e);
            addActionError(e.getMessage());
            return JsonActionSupport.SUCCESS;
        }
    }
    
    public String signOut() {
        AdminSessionUtils.removeSession();
        return JsonActionSupport.SUCCESS;
    }
    
    public interface ResultName {
        
        String LOGIN_SUCCESS = "login.success";
    }
    
    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

}
