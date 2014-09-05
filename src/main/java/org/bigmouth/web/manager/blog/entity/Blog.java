/*
 * 文件名称: Blog.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-29
 * 修改内容: 
 */
package org.bigmouth.web.manager.blog.entity;

import java.util.List;

import org.bigmouth.framework.entity.AuditEntity;

/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class Blog extends AuditEntity {

    private static final long serialVersionUID = 8276675565363457669L;

    private String title;

    private String content;

    private List<BlogTag> tags;

    private BlogRecommend blogRecommend;
    
    private Blog pre;
    
    private Blog next;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogTag> getTags() {
        return tags;
    }

    public void setTags(List<BlogTag> tags) {
        this.tags = tags;
    }

    public BlogRecommend getBlogRecommend() {
        return blogRecommend;
    }

    public void setBlogRecommend(BlogRecommend blogRecommend) {
        this.blogRecommend = blogRecommend;
    }

    public Blog getPre() {
        return pre;
    }

    public void setPre(Blog pre) {
        this.pre = pre;
    }

    public Blog getNext() {
        return next;
    }

    public void setNext(Blog next) {
        this.next = next;
    }

}
