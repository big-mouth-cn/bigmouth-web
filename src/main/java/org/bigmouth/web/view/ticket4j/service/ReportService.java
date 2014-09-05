package org.bigmouth.web.view.ticket4j.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.bigmouth.framework.util.PathUtils;
import org.bigmouth.ticket4j.report.Report;

import com.google.gson.Gson;


public class ReportService {
    
    private String tempDirectory = System.getProperty("java.io.tmpdir");
    
    public void init() {
        File directory = new File(tempDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void write(Report order, String fileName) throws IOException {
        File file = new File(PathUtils.appendEndFileSeparator(tempDirectory) + fileName);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(new Gson().toJson(order));
            bw.flush();
        }
        finally {
            IOUtils.closeQuietly(bw);
        }
    }

    public void setTempDirectory(String tempDirectory) {
        this.tempDirectory = tempDirectory;
    }
}
