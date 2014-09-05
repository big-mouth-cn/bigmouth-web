/*
 * 文件名称: RecommendAction.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-31
 * 修改内容: 
 */
package org.bigmouth.web.manager.comment.web;

import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.comment.entity.Comment;
import org.bigmouth.web.manager.comment.entity.CommentType;
import org.bigmouth.web.manager.comment.service.CommentService;
import org.bigmouth.web.manager.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Namespace("/")
@Action("c")
public class CommentAction extends JsonActionSupport {

    private static final long serialVersionUID = 4462841335942400035L;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentAction.class);
    
    private CommentService commentService;
    
    private PageInfo<Comment> page = new PageInfo<Comment>();
    
    private Long targetId;
    
    private String target;

    public String execute() {
        try {
            if (null == targetId)
                throw new IllegalArgumentException(Constants.Msg.INVALID_REQUEST);
            if (StringUtils.isBlank(target))
                throw new IllegalArgumentException(Constants.Msg.INVALID_REQUEST);
            CommentType targetType = CommentType.valueOf(target);
            if (null == targetType)
                throw new IllegalArgumentException(Constants.Msg.INVALID_REQUEST);
            List<Comment> recommends = commentService.queryByTarget(targetId, targetType, page);
            succeed(recommends);
        }
        catch (Exception e) {
            LOGGER.error("execute: ", e);
            failed(e.getMessage());
        }
        return NONE;
    }
    
    public void append() {
        try {
            if (null == targetId)
                throw new IllegalArgumentException(Constants.Msg.INVALID_REQUEST);
            if (StringUtils.isBlank(target))
                throw new IllegalArgumentException(Constants.Msg.INVALID_REQUEST);
            CommentType targetType = CommentType.valueOf(target);
            if (null == targetType)
                throw new IllegalArgumentException(Constants.Msg.INVALID_REQUEST);
            String name = getParameter("name");
            String content = getParameter("content");
            String parentId = getParameter("parentId");
            String email = getParameter("email");
            String headUrl = getParameter("headUrl");
            if (StringUtils.isBlank(content))
                throw new IllegalArgumentException("请说点什么吧");
            Comment object = new Comment(targetId, targetType);
            object.setQq(0L);
            object.setName(StringUtils.isBlank(name) ? "匿名" : name);
            object.setContent(content);
            object.setEmail(email);
            object.setHeadUrl(headUrl);
            if (StringUtils.isNumeric(parentId)) {
                object.setParentId(NumberUtils.toLong(parentId));
            }
            commentService.insert(object);
            succeed(object);
        }
        catch (Exception e) {
            failed(e.getMessage());
            LOGGER.error("append: ", e);
        }
    }
    
    public Long getTargetId() {
        return targetId;
    }
    
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }
    
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    public PageInfo<Comment> getPage() {
        return page;
    }
    
    public void setPage(PageInfo<Comment> page) {
        this.page = page;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    
}
