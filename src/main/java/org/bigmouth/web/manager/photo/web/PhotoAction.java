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
package org.bigmouth.web.manager.photo.web;

import java.io.File;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.album.entity.Album;
import org.bigmouth.web.manager.album.service.AlbumService;
import org.bigmouth.web.manager.constant.Constants;
import org.bigmouth.web.manager.master.service.FileService;
import org.bigmouth.web.manager.photo.entity.Photo;
import org.bigmouth.web.manager.photo.service.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Namespace("/manage")
@Action("photo")
@Results({
    @Result(name = JsonActionSupport.RELOAD, location = "/manage/photo.shtml?albumId=${albumId}", type = "redirect"),
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/manage/photo.jsp"),
    @Result(name = JsonActionSupport.INPUT, location = "/WEB-INF/pages/manage/photo-input.jsp")
})
public class PhotoAction extends JsonActionSupport implements ModelDriven<Photo>, Preparable {

    private static final long serialVersionUID = -5258352990494536789L;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoAction.class);
    
    private PhotoService photoService;
    
    private AlbumService albumService;
    
    private FileService fileService;
    
    private PageInfo<Photo> page = new PageInfo<Photo>();
    
    private Album album;
    
    private Photo entity;
    
    private Long albumId;
    
    private Long id;
    
    private File img;
    
    private String imgFileName;
    
    public String setPageCover() {
        try {
            String uri = getParameter("tileImg");
            albumService.updateTileImg(uri, albumId);
            addActionMessage("封面设置成功！");
        }
        catch (Exception e) {
            LOGGER.error("setPageCover: ", e);
            addActionError("封面设置失败！" + e.getMessage());
        }
        return RELOAD;
    }
    
    public void upload() {
        try {
            Photo photo = new Photo();
            fileService.store(photo, img, imgFileName, 250);
            photo.setTitle(imgFileName);
            photo.setAlbumId(albumId);
            photoService.save(photo);
            succeed(photo);
        }
        catch (Exception e) {
            LOGGER.error("upload: ", e);
            failed("File upload failed!" + e.getMessage());
        }
    }
    
    public String save() throws Exception {
        try {
            photoService.save(entity);
            return RELOAD;
        }
        catch (Exception e) {
            LOGGER.error("save: ", e);
            addActionError(Constants.Msg.SAVE_FAILED + e.getMessage());
            return input();
        }
    }
    
    public void delete() {
        try {
            photoService.delete(id);
            succeed();
        }
        catch (Exception e) {
            LOGGER.error("delete: ", e);
            failed("Delete failed!" + e.getMessage());
        }
    }
    
    @Override
    public String execute() throws Exception {
        return list();
    }

    @Override
    public String input() throws Exception {
        return INPUT;
    }

    public String list() {
        List<Photo> result = photoService.queryByAlbumId(albumId);
        page.setResult(result);
        page.initPageSource();
        album = albumService.query(albumId);
        return SUCCESS;
    }
    
    public void prepareInput() throws Exception {
        this.prepare();
    }

    @Override
    public void prepare() throws Exception {
        if (null != id) {
            entity = photoService.query(id);
        }
    }

    @Override
    public Photo getModel() {
        return entity;
    }

    public void setPhotoService(PhotoService photoService) {
        this.photoService = photoService;
    }
    
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public PageInfo<Photo> getPage() {
        return page;
    }

    public void setPage(PageInfo<Photo> page) {
        this.page = page;
    }
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public Photo getEntity() {
        return entity;
    }

    public void setEntity(Photo entity) {
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

}
