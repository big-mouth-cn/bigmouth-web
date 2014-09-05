/*
 * 文件名称: BlogTagRef.java
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

import org.bigmouth.framework.entity.IdEntity;

/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class BlogTagRef extends IdEntity {

    private static final long serialVersionUID = 4100448742864676866L;

    private Long blogId;

    private Long tagId;

    public BlogTagRef() {
        super();
    }

    public BlogTagRef(Long blogId, Long tagId) {
        super();
        this.blogId = blogId;
        this.tagId = tagId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

}
