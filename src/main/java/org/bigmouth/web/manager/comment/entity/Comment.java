/*
 * 文件名称: Recommend.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-31
 * 修改内容: 
 */
package org.bigmouth.web.manager.comment.entity;

import java.util.List;

import org.bigmouth.framework.entity.AuditEntity;

import com.google.gson.annotations.Expose;

/**
 * 评论
 * 
 * @author Allen.Hu / 2014-3-31
 */
public class Comment extends AuditEntity {

    private static final long serialVersionUID = 6362004195421464535L;

    @Expose private Long targetId;

    @Expose private CommentType targetType;

    @Expose private String name;

    @Expose private String content;

    @Expose private Long parentId;

    @Expose private Long qq;
    
    @Expose private String email;
    
    @Expose private String headUrl;
    
    /** 回复 */
    @Expose private List<Comment> childs;

    public Comment() {
        super();
    }

    public Comment(Long targetId, CommentType targetType) {
        super();
        this.targetId = targetId;
        this.targetType = targetType;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public CommentType getTargetType() {
        return targetType;
    }

    public void setTargetType(CommentType targetType) {
        this.targetType = targetType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public List<Comment> getChilds() {
        return childs;
    }

    public void setChilds(List<Comment> childs) {
        this.childs = childs;
    }

}
