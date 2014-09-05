/*
 * 文件名称: BlogTagAction.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-5-2
 * 修改内容: 
 */
package org.bigmouth.web.view.blog.web;

import java.util.List;

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

@Namespace("/")
@Action("tag")
@Results({
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/photo/index.jsp")
})
public class BlogTagAction extends SimpleActionSupport<BlogTag> {

    private static final long serialVersionUID = 1755067166249518282L;
    
    private BlogService blogService;
    
    private String tagName;

    private PageInfo<Blog> page = new PageInfo<Blog>();
    
    @Override
    public BlogTag getModel() {
        return null;
    }

    @Override
    public String list() throws Exception {
        List<Blog> result = blogService.queryByTag(tagName, page);
        page.setResult(result);
        page.initPageSource();
        return SUCCESS;
    }

    @Override
    protected void prepareModel() throws Exception {
    }

    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
