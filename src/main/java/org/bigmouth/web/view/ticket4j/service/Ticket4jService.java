package org.bigmouth.web.view.ticket4j.service;

import java.io.File;


public class Ticket4jService {
    
    private String filePath;

    public File getDownloadFile() {
        File file = new File(filePath);
        return file;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
