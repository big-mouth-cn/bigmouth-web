/*
 * 文件名称: AdminDao.java
 * 版权信息: Copyright 2005-2013 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-6-22
 * 修改内容: 
 */
package org.bigmouth.web.manager.master.dao;

import org.bigmouth.framework.dao.support.IMyBatisDao;
import org.bigmouth.web.manager.master.entity.Admin;


public interface AdminDao extends IMyBatisDao<Admin, Long> {

    /**
     * 根据登陆名和密码获取用户信息。
     * 
     * @param loginName 登陆名
     * @param password 密码
     * @return
     */
    Admin query(String loginName, String password);
}
