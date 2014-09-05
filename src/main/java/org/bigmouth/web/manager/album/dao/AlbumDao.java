/*
 * 文件名称: AlbumDao.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-4-4
 * 修改内容: 
 */
package org.bigmouth.web.manager.album.dao;

import org.bigmouth.framework.dao.support.IMyBatisDao;
import org.bigmouth.web.manager.album.entity.Album;


public interface AlbumDao extends IMyBatisDao<Album, Long> {

    void updateTileImg(String uri, long id);
}
