/*
 * 文件名称: LoginRedirect.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-5-14
 * 修改内容: 
 */
package org.bigmouth.web.view.qq.web;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.bigmouth.framework.util.Struts2Utils;
import org.bigmouth.framework.web.action.SimpleActionSupport;

import com.qq.connect.oauth.Oauth;

@Namespace("/")
@Action("auth")
public class LoginRedirect extends SimpleActionSupport<Object> {

    private static final long serialVersionUID = 393217860409107081L;

    @Override
    public String execute() throws Exception {
        Struts2Utils.getResponse().sendRedirect(new Oauth().getAuthorizeURL(getRequest()));
        return NONE;
    }

    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public String list() throws Exception {
        return null;
    }

    @Override
    protected void prepareModel() throws Exception {
    }

}
