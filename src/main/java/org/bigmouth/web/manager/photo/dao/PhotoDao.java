/*
 * 文件名称: PhotoDao.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-5
 * 修改内容: 
 */
package org.bigmouth.web.manager.photo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.bigmouth.framework.dao.page.PageInfo;
import org.bigmouth.framework.dao.support.IMyBatisDao;
import org.bigmouth.web.manager.photo.entity.Photo;


public interface PhotoDao extends IMyBatisDao<Photo, Long> {

    List<Photo> queryByAlbumId(long albumId);
    List<Photo> queryByAlbumId(long albumId, PageInfo<Photo> pageInfo);
    int getCount(long albumId);
    Photo queryPre(@Param("albumId") long albumId, @Param("id") long id);
    int queryCurrentIndex(@Param("albumId") long albumId, @Param("id") long id);
    Photo queryNext(@Param("albumId") long albumId, @Param("id") long id);
}
