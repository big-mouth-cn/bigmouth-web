/*
 * 文件名称: BlogTagRefDao.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-29
 * 修改内容: 
 */
package org.bigmouth.web.manager.blog.dao;

import org.bigmouth.framework.dao.support.IMyBatisDao;
import org.bigmouth.web.manager.blog.entity.BlogTagRef;


/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public interface BlogTagRefDao extends IMyBatisDao<BlogTagRef, Long> {

    void deleteByBlogId(Long blogId);
}
