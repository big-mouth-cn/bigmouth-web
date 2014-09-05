/*
 * 文件名称: BlogTagService.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-29
 * 修改内容: 
 */
package org.bigmouth.web.manager.blog.service;

import java.util.List;

import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.blog.dao.BlogTagDao;
import org.bigmouth.web.manager.blog.entity.BlogTag;


/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class BlogTagService extends MyBatisServiceSupport<BlogTag, Long, BlogTagDao> {
    
    private BlogTagDao blogTagDao;

    public List<BlogTag> queryByBlogId(Long blogId) {
        return blogTagDao.queryByBlogId(blogId);
    }

    @Override
    protected BlogTagDao getDao() {
        return blogTagDao;
    }
    
    public void setBlogTagDao(BlogTagDao blogTagDao) {
        this.blogTagDao = blogTagDao;
    }

}
