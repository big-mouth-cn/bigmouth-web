/*
 * 文件名称: BlogTagRefService.java
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

import org.apache.commons.collections.CollectionUtils;
import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.blog.dao.BlogTagRefDao;
import org.bigmouth.web.manager.blog.entity.Blog;
import org.bigmouth.web.manager.blog.entity.BlogTag;
import org.bigmouth.web.manager.blog.entity.BlogTagRef;


/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class BlogTagRefService extends MyBatisServiceSupport<BlogTagRef, Long, BlogTagRefDao> {
    
    private BlogTagRefDao blogTagRefDao;
    
    public void insert(Blog blog) {
        List<BlogTag> tags = blog.getTags();
        if (CollectionUtils.isNotEmpty(tags)) {
            for (BlogTag tag : tags) {
                BlogTagRef ref = new BlogTagRef(blog.getId(), tag.getId());
                insert(ref);
            }
        }
    }
    
    public void deleteByBlogId(Long blogId) {
        blogTagRefDao.deleteByBlogId(blogId);
    }

    @Override
    protected BlogTagRefDao getDao() {
        return blogTagRefDao;
    }

    public void setBlogTagRefDao(BlogTagRefDao blogTagRefDao) {
        this.blogTagRefDao = blogTagRefDao;
    }

}
