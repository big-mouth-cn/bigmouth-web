/*
 * 文件名称: AdminService.java
 * 版权信息: Copyright 2005-2013 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-6-22
 * 修改内容: 
 */
package org.bigmouth.web.manager.master.service;

import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.framework.util.MD5Utils;
import org.bigmouth.web.manager.master.dao.AdminDao;
import org.bigmouth.web.manager.master.entity.Admin;


public class AdminService extends MyBatisServiceSupport<Admin, Long, AdminDao> {

    private AdminDao adminDao;
    
    public Admin login(Admin entity) {
        if (null == entity) {
            throw new NullPointerException("entity");
        }
        String password = entity.getPassword();
        Admin admin = adminDao.query(entity.getLoginName(), MD5Utils.encode(password));
        return admin;
    }

    @Override
    protected AdminDao getDao() {
        return adminDao;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

}
