/*
 * 文件名称: BlogRecommend.java
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
public class BlogRecommend extends IdEntity {

    private static final long serialVersionUID = -7803070726307331313L;

    private Integer sequence = 0;

    private Long blogId;
    
    public BlogRecommend() {
        super();
    }

    public BlogRecommend(Long blogId) {
        super();
        this.blogId = blogId;
    }

    public BlogRecommend(Integer sequence, Long blogId) {
        super();
        this.sequence = sequence;
        this.blogId = blogId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

}
