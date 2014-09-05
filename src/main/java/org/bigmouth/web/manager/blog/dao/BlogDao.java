/*
 * 文件名称: BlogDao.java
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

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.dao.support.IMyBatisDao;
import org.bigmouth.web.manager.blog.entity.Blog;


/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public interface BlogDao extends IMyBatisDao<Blog, Long> {

    List<Blog> queryRecommend();
    
    List<Blog> queryByTag(@Param("tagName") String tagName, PageInfo<Blog> pageInfo);
    
    Blog queryPre(@Param("id") long id);
    
    Blog queryNext(@Param("id") long id);
}
