package org.bigmouth.web.manager.master.entity;

import org.bigmouth.framework.entity.IdEntity;

public class Admin extends IdEntity {

    private static final long serialVersionUID = 2412341980049766990L;

    private String loginName;

    private String password;

    private String name;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}