/*
 * 文件名称: Constants.java
 * 版权信息: Copyright 2005-2013 SKY-MOBI Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-3-30
 * 修改内容: 
 */
package org.bigmouth.web.manager.constant;

/**
 * 系统常量定义。
 * 
 * @author Allen.Hu / 2013-3-30
 */
public final class Constants {

    private Constants() {
    }
    
    public static interface Msg {
        
        String INVALID_REQUEST = "无效的请求！";
        
        String SAVE_FAILED = "保存失败！";
    }
}
