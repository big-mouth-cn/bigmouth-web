/*
 * 文件名称: PhotoAction.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-10
 * 修改内容: 
 */
package org.bigmouth.web.view.photo.web;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.album.entity.Album;
import org.bigmouth.web.manager.album.service.AlbumService;
import org.bigmouth.web.manager.photo.entity.Photo;
import org.bigmouth.web.manager.photo.service.PhotoService;


@Namespace("/")
@Action("p")
@Results({
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/photo/index.jsp"),
    @Result(name = PhotoAction.THREAD, location = "/WEB-INF/pages/photo/thread.jsp")
})
public class PhotoAction extends SimpleActionSupport<Photo> {

    private static final long serialVersionUID = -1466757330282465373L;
    
    public static final String THREAD = "thread";
    
    private AlbumService albumService;
    
    private PhotoService photoService;
    
    private Album album;
    
    private PageInfo<Photo> page = new PageInfo<Photo>();
    
    private Photo photo;
    
    private Photo pre;
    
    private Photo next;
    
    private int currentIndex;
    
    private int albumCount;
    
    private Long albumId;
    
    private Long id;

    @Override
    public Photo getModel() {
        return null;
    }
    
    public String thread() {
        album = albumService.query(albumId);
        albumCount = photoService.getCount(albumId);
        photo = photoService.query(id);
        pre = photoService.queryPre(albumId, id);
        currentIndex = photoService.queryCurrentIndex(albumId, id);
        next = photoService.queryNext(albumId, id);
        return THREAD;
    }

    @Override
    public String list() throws Exception {
        List<Photo> result = photoService.queryByAlbumId(albumId);
        page.setResult(result);
        album = albumService.query(albumId);
        albumCount = photoService.getCount(albumId);
        return SUCCESS;
    }

    @Override
    protected void prepareModel() throws Exception {
    }
    
    public Album getAlbum() {
        return album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }

    public PageInfo<Photo> getPage() {
        return page;
    }

    public void setPage(PageInfo<Photo> page) {
        this.page = page;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
    
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    public void setPhotoService(PhotoService photoService) {
        this.photoService = photoService;
    }

    public Photo getPhoto() {
        return photo;
    }
    
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(int albumCount) {
        this.albumCount = albumCount;
    }

    public Photo getPre() {
        return pre;
    }

    public void setPre(Photo pre) {
        this.pre = pre;
    }
    
    public int getCurrentIndex() {
        return currentIndex;
    }
    
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Photo getNext() {
        return next;
    }

    public void setNext(Photo next) {
        this.next = next;
    }

}
