/*
 * 文件名称: AlbumAction.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-10
 * 修改内容: 
 */
package org.bigmouth.web.view.album;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.album.entity.Album;
import org.bigmouth.web.manager.album.service.AlbumService;

import com.google.common.collect.Lists;


@Namespace("/")
@Action("album")
@Results({
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/album/index.jsp")
})
public class AlbumAction extends SimpleActionSupport<Album> {

    private static final long serialVersionUID = 128968960458771848L;
    
    private AlbumService albumService;
    
    private List<Album> result = Lists.newArrayList();

    @Override
    public Album getModel() {
        return null;
    }

    @Override
    public String list() throws Exception {
        result = albumService.queryAll();
        return SUCCESS;
    }

    @Override
    protected void prepareModel() throws Exception {
    }
    
    public List<Album> getResult() {
        return result;
    }

    public void setResult(List<Album> result) {
        this.result = result;
    }

    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

}
