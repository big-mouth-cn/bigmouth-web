/*
 * 文件名称: FileAction.java
 * 版权信息: Copyright 2005-2013 Allen.Hu Inc. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Allen.Hu
 * 修改日期: 2013-6-22
 * 修改内容: 
 */
package org.bigmouth.web.manager.master.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.manager.master.service.FileService;


@Namespace("/manage")
@Action("file")
@Results({
})
public class FileAction extends JsonActionSupport {

    private static final long serialVersionUID = 4586095231976087014L;
    
    private FileService fileService;

    private File imgFile;
    
    private String imgFileFileName;

    public void upload() {
        try {
            doSuccess(fileService.store(imgFile, imgFileFileName));
        }
        catch (FileUploadException e) {
            doFail(e.getMessage());
        }
        catch (IOException e) {
            doFail(e.getMessage());
        }
    }

    private void doSuccess(String url) throws IOException {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("error", 0);
        obj.put("url", url);
        doResponse(obj);
    }
    
    private void doFail(String errorMessage) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("error", 0);
        obj.put("message", errorMessage);
        try {
            doResponse(obj);
        }
        catch (Exception e) {
            ;
        }
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public String getImgFileFileName() {
        return imgFileFileName;
    }

    public void setImgFileFileName(String imgFileFileName) {
        this.imgFileFileName = imgFileFileName;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

}
