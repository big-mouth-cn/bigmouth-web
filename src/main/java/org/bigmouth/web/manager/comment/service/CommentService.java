/*
 * 文件名称: RecommendService.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-31
 * 修改内容: 
 */
package org.bigmouth.web.manager.comment.service;

import java.util.List;

import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.comment.dao.CommentDao;
import org.bigmouth.web.manager.comment.entity.Comment;
import org.bigmouth.web.manager.comment.entity.CommentType;


public class CommentService extends MyBatisServiceSupport<Comment, Long, CommentDao> {
    
    private CommentDao commentDao;
    
    public List<Comment> queryByTarget(Long targetId, CommentType targetType, PageInfo<Comment> page) {
        if (CommentType.BLOG.equals(targetType)) {
            return queryByBlog(targetId, page);
        }
        else if (CommentType.PHOTO.equals(targetType)) {
        }
        return null;
    }
    
    public List<Comment> queryByBlog(Long blogId, PageInfo<Comment> page) {
        Comment condition = new Comment(blogId, CommentType.BLOG);
        return commentDao.queryAll(condition, page);
    }

    @Override
    protected CommentDao getDao() {
        return commentDao;
    }
    
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

}
