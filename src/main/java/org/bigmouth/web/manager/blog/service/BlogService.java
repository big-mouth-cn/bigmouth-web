/*
 * 文件名称: BlogService.java
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

import org.bigmouth.framework.dao.exception.NullColumnException;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.blog.dao.BlogDao;
import org.bigmouth.web.manager.blog.entity.Blog;
import org.bigmouth.web.manager.blog.entity.BlogRecommend;
import org.bigmouth.web.manager.blog.entity.BlogTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class BlogService extends MyBatisServiceSupport<Blog, Long, BlogDao> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogService.class);
    
    private BlogDao blogDao;
    
    private BlogTagService blogTagService;
    
    private BlogTagRefService blogTagRefService;
    
    private BlogRecommendService blogRecommendService;

    public void save(Blog blog) {
        if (null == blog) {
            throw new NullPointerException("blog");
        }
        
        if (blog.getId() == null) {
            super.insert(blog);
        }
        else {
            blogRecommendService.deleteByBlogId(blog.getId());
            blogTagRefService.deleteByBlogId(blog.getId());
            super.update(blog);
        }
        blogTagRefService.insert(blog);
        blogRecommendService.insert(blog);
    }
    
    @Override
    public void delete(Long id) {
        blogRecommendService.deleteByBlogId(id);
        blogTagRefService.deleteByBlogId(id);
        super.delete(id);
    }

    @Override
    public Blog query(Long id) {
        Blog blog = super.query(id);
        fillExtraProperty(blog);
        blog.setPre(queryPre(id));
        blog.setNext(queryNext(id));
        return blog;
    }
    
    public Blog queryPre(Long id) {
        return blogDao.queryPre(id);
    }
    
    public Blog queryNext(Long id) {
        return blogDao.queryNext(id);
    }

    @Override
    public List<Blog> queryAll(PageInfo<Blog> pageInfo) {
        List<Blog> result = super.queryAll(pageInfo);
        fillExtraProperty(result);
        return result;
    }
    
    public List<Blog> queryByTag(String tagName, PageInfo<Blog> pageInfo) {
        List<Blog> result = blogDao.queryByTag(tagName, pageInfo);
        fillExtraProperty(result);
        return result;
    }

    public List<Blog> queryRecommend() {
        List<Blog> result = blogDao.queryRecommend();
        fillExtraProperty(result);
        return result;
    }
    
    private void fillExtraProperty(List<Blog> blogs) {
        for (Blog blog : blogs) {
            fillExtraProperty(blog);
        }
    }

    private void fillExtraProperty(Blog blog) {
        List<BlogTag> tags = blogTagService.queryByBlogId(blog.getId());
        blog.setTags(tags);
        try {
            BlogRecommend blogRecommend = blogRecommendService.queryUnique("blog_id", blog.getId());
            blog.setBlogRecommend(blogRecommend);
        }
        catch (NullColumnException e) {
            LOGGER.error("fillExtraProperty:", e);
        }
    }
    
    @Override
    protected BlogDao getDao() {
        return blogDao;
    }

    public void setBlogDao(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public void setBlogTagService(BlogTagService blogTagService) {
        this.blogTagService = blogTagService;
    }

    public void setBlogRecommendService(BlogRecommendService blogRecommendService) {
        this.blogRecommendService = blogRecommendService;
    }

    public void setBlogTagRefService(BlogTagRefService blogTagRefService) {
        this.blogTagRefService = blogTagRefService;
    }

}
