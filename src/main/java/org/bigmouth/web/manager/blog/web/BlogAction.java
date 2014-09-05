/*
 * 文件名称: AdminAction.java
 * 版权信息: Copyright 2005-2013 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-6-22
 * 修改内容: 
 */
package org.bigmouth.web.manager.blog.web;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.web.manager.blog.entity.Blog;
import org.bigmouth.web.manager.blog.entity.BlogRecommend;
import org.bigmouth.web.manager.blog.entity.BlogTag;
import org.bigmouth.web.manager.blog.service.BlogService;
import org.bigmouth.web.manager.blog.service.BlogTagService;
import org.bigmouth.web.manager.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

@Namespace("/manage")
@Action("blog")
@Results({
    @Result(name = SimpleActionSupport.RELOAD, location = "/manage/blog.shtml", type = "redirect"),
    @Result(name = SimpleActionSupport.SUCCESS, location = "/WEB-INF/pages/manage/blog.jsp"),
    @Result(name = SimpleActionSupport.INPUT, location = "/WEB-INF/pages/manage/blog-input.jsp")
})
public class BlogAction extends SimpleActionSupport<Blog> {

    private static final long serialVersionUID = -5258352990494536789L;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogAction.class);
    
    private BlogService blogService;
    
    private BlogTagService blogTagService;
    
    private PageInfo<Blog> page = new PageInfo<Blog>();
    
    private List<BlogTag> allTags;
    
    private Blog entity;
    
    private Long id;
    
    /** Checked tags */
    private Long[] chkTags;
    
    @Override
    public String input() {
        return INPUT;
    }
    
    public String save() {
        try {
            String isRecommend = getParameter("isRecommend");
            if (StringUtils.isNotBlank(isRecommend)) {
                entity.setBlogRecommend(new BlogRecommend());
            }
            if (chkTags.length <= 0) {
                addActionError("必须最少为博文设置一个分类");
                return INPUT;
            }
            List<BlogTag> blogTags = getBlogTags();
            entity.setTags(blogTags);
            blogService.save(entity);
            return RELOAD;
        }
        catch (Exception e) {
            addActionError(Constants.Msg.SAVE_FAILED + e.getMessage());
            LOGGER.error("save:", e);
            return input();
        }
    }

    @Override
    public String delete() throws Exception {
        blogService.delete(id);
        return RELOAD;
    }

    private List<BlogTag> getBlogTags() {
        List<BlogTag> blogTags = Lists.newArrayList();
        for (Long tag : chkTags) {
            BlogTag blogTag = new BlogTag();
            blogTag.setId(tag);
            blogTags.add(blogTag);
        }
        return blogTags;
    }

    @Override
    public Blog getModel() {
        return entity;
    }

    @Override
    public String list() throws Exception {
        List<Blog> result = blogService.queryAll(page);
        page.setResult(result);
        page.initPageSource();
        return SUCCESS;
    }

    @Override
    protected void prepareModel() throws Exception {
        allTags = blogTagService.queryAll();
        if (null != id) {
            entity = blogService.query(id);
            
            int size = 0;
            if (CollectionUtils.isNotEmpty(entity.getTags())) {
                size = entity.getTags().size();
            }
            chkTags = new Long[size];
            for (int i = 0; i < size; i++) {
                chkTags[i] = entity.getTags().get(i).getId();
            }
        }
    }
    
    public Blog getEntity() {
        return entity;
    }

    public void setEntity(Blog entity) {
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }
    
    public PageInfo<Blog> getPage() {
        return page;
    }
    
    public void setPage(PageInfo<Blog> page) {
        this.page = page;
    }

    public void setBlogTagService(BlogTagService blogTagService) {
        this.blogTagService = blogTagService;
    }

    public List<BlogTag> getAllTags() {
        return allTags;
    }
    
    public void setAllTags(List<BlogTag> allTags) {
        this.allTags = allTags;
    }

    public Long[] getChkTags() {
        return chkTags;
    }
    
    public void setChkTags(Long[] chkTags) {
        this.chkTags = chkTags;
    }

}
