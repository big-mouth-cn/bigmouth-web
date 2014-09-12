package org.bigmouth.web.view.ticket4j.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bigmouth.framework.util.PathUtils;
import org.bigmouth.ticket4j.report.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class ReportService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportService.class);
    
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
    
    public List<Report> read() {
        List<Report> reports = Lists.newArrayList();
        File directory = new File(tempDirectory);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                try {
                    String content = getContentForFile(file);
                    Report report = new Gson().fromJson(content, Report.class);
                    reports.add(report);
                }
                catch (JsonSyntaxException e) {
                    LOGGER.error("read:", e);
                }
                catch (FileNotFoundException e) {
                    LOGGER.error("read:", e);
                }
                catch (IOException e) {
                    LOGGER.error("read:", e);
                }
            }
        }
        return reports;
    }

    private String getContentForFile(File file) throws FileNotFoundException, IOException {
        StringBuilder content = new StringBuilder(512);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }
        finally {
            IOUtils.closeQuietly(br);
        }
        return content.toString();
    }

    public void setTempDirectory(String tempDirectory) {
        this.tempDirectory = tempDirectory;
    }
}
