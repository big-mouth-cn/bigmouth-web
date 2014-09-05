/*
 * 文件名称: AdminAction.java
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

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.master.entity.Admin;
import org.bigmouth.web.manager.utils.AdminSessionUtils;

@Namespace("/manage")
@Action("home")
@Results({
    @Result(name = JsonActionSupport.RELOAD, location = "/manage/home.shtml", type = "redirect"),
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/manage/home.jsp")
})
public class AdminAction extends JsonActionSupport {

    private static final long serialVersionUID = -5258352990494536789L;
    
    private Admin admin;
    
    @Override
    public String execute() throws Exception {
        admin = AdminSessionUtils.getSession();
        return JsonActionSupport.SUCCESS;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
