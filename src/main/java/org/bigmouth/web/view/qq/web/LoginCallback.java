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

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.util.Struts2Utils;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

@Namespace("/auth")
@Action("successful")
@Results({ @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/auth/QQLoginSuccessful.jsp") })
public class LoginCallback extends SimpleActionSupport<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCallback.class);

    private static final long serialVersionUID = 393217860409107081L;

    @Override
    public String execute() throws Exception {
        try {
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(getRequest());
            if (accessTokenObj.getAccessToken().equals("")) {
                LOGGER.warn("QQ Login没有获取到响应参数。");
            }
            else {
                HttpSession session = Struts2Utils.getSession();
                String accessToken = accessTokenObj.getAccessToken();
                session.setAttribute(Constants.ACCESS_TOKEN, accessToken);
                session.setAttribute(Constants.TOKEN_EXPIRE, String.valueOf(accessTokenObj.getExpireIn()));
                OpenID openIDObj = new OpenID(accessToken);
                String openID = openIDObj.getUserOpenID();
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    session.setAttribute(Constants.USER_INFO_BEAN, userInfoBean);
                }
            }
        }
        catch (QQConnectException e) {
            LOGGER.error("QQ Auth2.0: ", e);
        }
        return SUCCESS;
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
