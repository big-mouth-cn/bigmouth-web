package org.bigmouth.web.view.ticket4j.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.bigmouth.framework.util.FileUtils;
import org.bigmouth.framework.web.action.SimpleActionSupport;
import org.bigmouth.framework.web.action.json.JsonActionSupport;
import org.bigmouth.web.view.ticket4j.service.Ticket4jService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Namespace("/")
@Action("ticket4j")
@Results({
    @Result(name = JsonActionSupport.SUCCESS, location = "/WEB-INF/pages/ticket4j/index.jsp"),
    @Result(name = Ticket4jAction.DOWNLOAD, type = "stream", params = 
    { 
        "inputName", "inputStream", 
        "contentDisposition", "attachment;filename=%{downloadFileName}",
        "bufferSize", "2048" 
    })
})
public class Ticket4jAction extends SimpleActionSupport<Object> {

    private static final long serialVersionUID = -5676533345473744809L;
    private static final Logger LOGGER = LoggerFactory.getLogger(Ticket4jAction.class);
    public static final String DOWNLOAD = "download";
    
    private Ticket4jService ticket4jService;
    private File file;
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String download() {
        return DOWNLOAD;
    }
    
    public InputStream getInputStream() {
        try {
            file = ticket4jService.getDownloadFile();
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            return FileUtils.getInputStream(file);
        }
        catch (Exception e) {
            LOGGER.error("getInputStream:" + e.getMessage());
        }
        return null;
    }
    
    public String getDownloadFileName() {
        return file.getName();
    }
    
    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public String list() throws Exception {
        return null;
    }

    @Override
    protected void prepareModel() throws Exception {
    }

    public void setTicket4jService(Ticket4jService ticket4jService) {
        this.ticket4jService = ticket4jService;
    }
}
