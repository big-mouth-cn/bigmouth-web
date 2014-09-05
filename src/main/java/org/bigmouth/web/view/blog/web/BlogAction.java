/*
 * 文件名称: BlogAction.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-19
 * 修改内容: 
 */
package org.bigmouth.web.view.blog.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.blog.entity.Blog;
import org.bigmouth.web.manager.blog.entity.BlogTag;
import org.bigmouth.web.manager.blog.service.BlogService;
import org.bigmouth.web.manager.blog.service.BlogTagService;

import com.google.common.collect.Lists;


@Namespace("/")
@Action("blog")
@Results({
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/blog/index.jsp"),
    @Result(name = BlogAction.RESULT_THREAD, location = "/WEB-INF/pages/blog/thread.jsp")
})
public class BlogAction extends SimpleActionSupport<Blog> {

    private static final long serialVersionUID = 1849914771864301629L;
    
    public static final String RESULT_THREAD = "thread";
    
    public static final String CUT_TAG = "<a name=\"cut\"></a>";
    
    private BlogService blogService;
    
    private BlogTagService blogTagService;
    
    private List<BlogTag> allTags;
    
    private List<Blog> recommend;

    private PageInfo<Blog> page = new PageInfo<Blog>();
    
    private Blog entity;
    
    private Long id;
    
    private String tagName;
    
    @Override
    public String execute() throws Exception {
        return list();
    }

    @Override
    public Blog getModel() {
        return null;
    }

    @Override
    public String list() throws Exception {
        List<Blog> result = Lists.newArrayList();
        if (StringUtils.isBlank(tagName)) {
            result = blogService.queryAll(page);
        }
        else {
            result = blogService.queryByTag(tagName, page);
        }
        for (Blog blog : result) {
            String content = blog.getContent();
            if (StringUtils.indexOf(content, CUT_TAG) != -1) {
                content = StringUtils.substring(content, 0, StringUtils.indexOf(content, CUT_TAG)) + "...";
                blog.setContent(content);
            }
        }
        page.setResult(result);
        page.initPageSource();
        allTags = blogTagService.queryAll();
        recommend = blogService.queryRecommend();
        return SUCCESS;
    }
    
    public String thread() {
        return RESULT_THREAD;
    }
    
    public void prepareThread() throws Exception {
        prepareModel();
    }
    
    @Override
    protected void prepareModel() throws Exception {
        allTags = blogTagService.queryAll();
        if (null != id) {
            entity = blogService.query(id);
        }
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
    
    public List<BlogTag> getAllTags() {
        return allTags;
    }

    public void setBlogTagService(BlogTagService blogTagService) {
        this.blogTagService = blogTagService;
    }
    
    public Blog getEntity() {
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<Blog> getRecommend() {
        return recommend;
    }
    
}
