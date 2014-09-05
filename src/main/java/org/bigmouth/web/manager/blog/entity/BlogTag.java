/*
 * 文件名称: BlogTag.java
 * 版权信息: Copyright 2005-2014 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2014-3-29
 * 修改内容: 
 */
package org.bigmouth.web.manager.blog.entity;

import org.bigmouth.framework.entity.IdEntity;

/**
 * 
 * @author Allen.Hu / 2014-3-29
 */
public class BlogTag extends IdEntity {

    private static final long serialVersionUID = -4370746851540688354L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
