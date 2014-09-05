/*
 * 文件名称: AlbumService.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-4
 * 修改内容: 
 */
package org.bigmouth.web.manager.album.service;

import java.util.List;

import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.album.dao.AlbumDao;
import org.bigmouth.web.manager.album.entity.Album;
import org.bigmouth.web.manager.constant.Constants;
import org.bigmouth.web.manager.photo.entity.Photo;
import org.bigmouth.web.manager.photo.service.PhotoService;


public class AlbumService extends MyBatisServiceSupport<Album, Long, AlbumDao> {
    
    private AlbumDao albumDao;
    
    private PhotoService photoService;
    
    public void save(Album entity) {
        if (null == entity) {
            throw new NullPointerException(Constants.Msg.INVALID_REQUEST);
        }
        if (null == entity.getId()) {
            insert(entity);
        }
        else {
            update(entity);
        }
    }
    
    public void updateTileImg(String uri, long id) {
        albumDao.updateTileImg(uri, id);
    }

    @Override
    public void delete(Long id) {
        List<Photo> photos = photoService.queryByAlbumId(id);
        for (Photo photo : photos) {
            photoService.delete(photo.getId());
        }
        super.delete(id);
    }

    @Override
    protected AlbumDao getDao() {
        return albumDao;
    }

    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    public void setPhotoService(PhotoService photoService) {
        this.photoService = photoService;
    }

}
