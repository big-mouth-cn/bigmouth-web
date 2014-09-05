/*
 * 文件名称: BlogRecommendService.java
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

import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.blog.dao.BlogRecommendDao;
import org.bigmouth.web.manager.blog.entity.Blog;
import org.bigmouth.web.manager.blog.entity.BlogRecommend;


/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class BlogRecommendService extends MyBatisServiceSupport<BlogRecommend, Long, BlogRecommendDao> {
    
    private BlogRecommendDao blogRecommendDao;

    public void insert(Blog blog) {
        if (null != blog.getBlogRecommend()) {
            blog.getBlogRecommend().setBlogId(blog.getId());
            insert(blog.getBlogRecommend());
        }
    }
    
    public void deleteByBlogId(Long blogId) {
        blogRecommendDao.deleteByBlogId(blogId);
    }
    
    @Override
    protected BlogRecommendDao getDao() {
        return blogRecommendDao;
    }

    public void setBlogRecommendDao(BlogRecommendDao blogRecommendDao) {
        this.blogRecommendDao = blogRecommendDao;
    }

}
