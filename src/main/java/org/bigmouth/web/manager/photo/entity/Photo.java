/*
 * 文件名称: Photo.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-4
 * 修改内容: 
 */
package org.bigmouth.web.manager.photo.entity;

import org.bigmouth.framework.entity.AuditEntity;

import com.google.gson.annotations.Expose;

/**
 * 相片
 * 
 * @author Allen.Hu / 2014-4-4
 */
public class Photo extends AuditEntity {

    private static final long serialVersionUID = -3623549880104833877L;

    @Expose private Long albumId;

    @Expose private String title;

    @Expose private String description;

    @Expose private String photoUri;

    @Expose private String cameraInfo;
    
    @Expose private String thumbnailUri;
    
    @Expose private int thumbnailWidth = 0;
    
    @Expose private int thumbnailHeight = 0;
    
    @Expose private int sequence = 0;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public String getCameraInfo() {
        return cameraInfo;
    }

    public void setCameraInfo(String cameraInfo) {
        this.cameraInfo = cameraInfo;
    }
    
    public String getThumbnailUri() {
        return thumbnailUri;
    }

    public void setThumbnailUri(String thumbnailUri) {
        this.thumbnailUri = thumbnailUri;
    }
    
    public int getThumbnailWidth() {
        return thumbnailWidth;
    }
    
    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

}
