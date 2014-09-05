/*
 * 文件名称: PhotoService.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-5
 * 修改内容: 
 */
package org.bigmouth.web.manager.photo.service;

import java.util.List;

import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.dao.support.MyBatisServiceSupport;
import org.bigmouth.web.manager.constant.Constants;
import org.bigmouth.web.manager.master.service.FileService;
import org.bigmouth.web.manager.photo.dao.PhotoDao;
import org.bigmouth.web.manager.photo.entity.Photo;


public class PhotoService extends MyBatisServiceSupport<Photo, Long, PhotoDao> {
    
    private PhotoDao photoDao;
    
    private FileService fileService;
    
    public List<Photo> queryByAlbumId(long albumId) {
        return photoDao.queryByAlbumId(albumId);
    }
    
    public List<Photo> queryByAlbumId(long albumId, PageInfo<Photo> pageInfo) {
        return photoDao.queryByAlbumId(albumId, pageInfo);
    }
    
    public int getCount(long albumId) {
        return photoDao.getCount(albumId);
    }
    
    public Photo queryPre(long albumId, long id) {
        return photoDao.queryPre(albumId, id);
    }
    
    public int queryCurrentIndex(long albumId, long id) {
        return photoDao.queryCurrentIndex(albumId, id);
    }
    
    public Photo queryNext(long albumId, long id) {
        return photoDao.queryNext(albumId, id);
    }
    
    public void save(Photo entity) {
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

    @Override
    public void delete(Long id) {
        Photo photo = query(id);
        super.delete(id);
        String photoUri = photo.getPhotoUri();
        String thumbnailUri = photo.getThumbnailUri();
        fileService.delete(photoUri);
        fileService.delete(thumbnailUri);
    }

    @Override
    protected PhotoDao getDao() {
        return photoDao;
    }

    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

}
