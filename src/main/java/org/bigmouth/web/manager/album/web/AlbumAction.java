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
package org.bigmouth.web.manager.album.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.web.manager.album.entity.Album;
import org.bigmouth.web.manager.album.service.AlbumService;
import org.bigmouth.web.manager.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

@Namespace("/manage")
@Action("album")
@Results({
    @Result(name = SimpleActionSupport.RELOAD, location = "/manage/album.shtml", type = "redirect"),
    @Result(name = SimpleActionSupport.SUCCESS, location = "/WEB-INF/pages/manage/album.jsp"),
    @Result(name = SimpleActionSupport.INPUT, location = "/WEB-INF/pages/manage/album-input.jsp")
})
public class AlbumAction extends SimpleActionSupport<Album> {

    private static final long serialVersionUID = -5258352990494536789L;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumAction.class);
    
    private AlbumService albumService;
    
    private List<Album> list = Lists.newArrayList();
    
    private Album entity;
    
    private Long id;
    
    @Override
    public String save() throws Exception {
        try {
            albumService.save(entity);
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
        albumService.delete(id);
        return RELOAD;
    }

    @Override
    public Album getModel() {
        return entity;
    }

    @Override
    public String list() throws Exception {
        list = albumService.queryAll();
        return SUCCESS;
    }

    @Override
    protected void prepareModel() throws Exception {
        if (null != id) {
            entity = albumService.query(id);
        }
    }

    public AlbumService getAlbumService() {
        return albumService;
    }

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public Album getEntity() {
        return entity;
    }

    public void setEntity(Album entity) {
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Album> getList() {
        return list;
    }

    public void setList(List<Album> list) {
        this.list = list;
    }

}
