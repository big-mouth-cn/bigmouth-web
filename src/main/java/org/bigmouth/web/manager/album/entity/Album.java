/*
 * 文件名称: Album.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-4
 * 修改内容: 
 */
package org.bigmouth.web.manager.album.entity;

import org.bigmouth.framework.entity.AuditEntity;

import com.google.gson.annotations.Expose;


/**
 * 相册
 * 
 * @author Allen.Hu / 2014-4-4
 */
public class Album extends AuditEntity {

    private static final long serialVersionUID = 5963922828881241724L;

    @Expose private String name;
    
    @Expose private String tileImg;
    
    @Expose private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTileImg() {
        return tileImg;
    }

    public void setTileImg(String tileImg) {
        this.tileImg = tileImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
